package com.iron.ncp.task;

import com.iron.ncp.dao.WeatherMapper;
import com.iron.ncp.entity.Weather;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Description:
 * User: gaoyf
 * Date: 2020/2/14
 */
@Slf4j
@Component
public class WeatherTask {
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private WeatherMapper weatherMapper;

    String url = "http://t.weather.sojson.com/api/weather/city/";

    private final static String E_X = "[^0-9]+";


    //获取天气
    @Scheduled(fixedRateString = "${data.task.weather:3600000}")
    @PostConstruct
    public void weatherData() {
        DateTime dateTime = new DateTime();
        String d = dateTime.toString("yyyy-MM-dd");
        for (Integer integer : WEATHER_MAP.keySet()) {
            try {
                Object forObject = restTemplate.getForObject(url + integer, Object.class);
                HashMap map = (HashMap) forObject;
                HashMap data = (HashMap) map.get("data");
                String wendu = data.get("wendu").toString();
                String shidu = data.get("shidu").toString();
                String pm = data.get("pm25").toString();
                Weather weather = new Weather();
                weather.setTemp(Float.parseFloat(wendu));
                weather.setHumidity(shidu);
                weather.setPm25(Float.parseFloat(pm));
                weather.setCreated(new Date());
                weather.setArea(WEATHER_MAP.get(integer));
                ArrayList<HashMap> forecast = (ArrayList) data.get("forecast");
                Pattern compile = Pattern.compile(E_X);
                for (HashMap o : forecast) {
                    if (o.get("ymd").equals(d)) {
                        String type = o.get("type").toString();
                        weather.setWeatherType(type);
                        weather.setFl(o.get("fl").toString());
                        String high = o.get("high").toString().replaceAll(" ","").trim();
                        String low = o.get("low").toString().replaceAll(" ","").trim();
                        Optional<String> s = Optional.ofNullable(high);
                        s.ifPresent(x -> {
                            String[] split = compile.split(x);
                            weather.setHighTp(Float.parseFloat(split[1]));
                        });
                        Optional<String> lows = Optional.ofNullable(low);
                        lows.ifPresent(x -> {
                            String[] split = compile.split(x);
                            weather.setLowTp(Float.parseFloat(split[1]));
                        });
                    }
                    break;
                }
                //校验
                Weather check = new Weather();
                check.setArea(WEATHER_MAP.get(integer));
                List<Weather> select = weatherMapper.select(check);
                if (select.size() > 0) {
                    weather.setId(select.get(0).getId());
                    weatherMapper.updateByPrimaryKey(weather);
                } else {
                    weatherMapper.insert(weather);
                }
            } catch (Exception e) {
                log.warn("{}", e);
            }

        }

    }

    public static final Map<Integer, String> WEATHER_MAP = new HashMap<>();

    static {
        WEATHER_MAP.put(101270107, "郫都区");
        WEATHER_MAP.put(101270114, "崇州市");
        WEATHER_MAP.put(101270106, "双流区");
        WEATHER_MAP.put(101270110, "新津县");
        WEATHER_MAP.put(101270101, "天府新区");
    }

}
