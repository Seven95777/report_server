package com.iron.ncp.config;

import com.iron.ncp.utils.BusinessCode;
import com.iron.ncp.utils.EnumUtil;
import com.iron.ncp.utils.RestResult;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * 全局controller处理
 */
@ControllerAdvice
@Slf4j
public class ControllerSetup {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public Object defaultErrorHandler(Exception e) {
        String message = "服务器发生未知错误，请联系管理员";
        int code = 1100100;
        if (e instanceof UpdateException) {
            code = 1100101;
            message = "不存在对应ID和版本的数据";
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            code = 1100102;
            message = "系统不支持 " + ((HttpRequestMethodNotSupportedException) e).getMethod() + " 请求方式";
        } else if (e instanceof HttpMediaTypeNotSupportedException) {
            code = 1100102;
            message = "系统不支持 " + ((HttpMediaTypeNotSupportedException) e).getContentType() + " 请求方式";
        } else if (e instanceof HttpMessageNotReadableException) {
            code = 1100103;
            message = "无法正确解析所需参数，这可能由于请求参数格式、类型、范围错误造成";
        } else if (e instanceof MyBatisSystemException) {
            code = 1100104;
            message = "Mybatis相关异常";
            log.warn("Mybatis相关异常:{}",e);
        } else if (e instanceof NullPointerException) {
            code = 1100105;
            message = "空指针异常";
            log.warn("空指针异常:{}",e);
        } else if (e instanceof MySQLSyntaxErrorException) {
            code = 1100106;
            message = "该日期数据表不存在";
        } else if (e instanceof BadSqlGrammarException) {
            code = 1100107;
            message = "sql错误";
            log.warn("空指针异常:{}",e);
        }else if (e instanceof MyRuntimeException) {
            //自定义运行时异常 转 自定义json返回
            message = e.getMessage();
            if (message != null) {
                BusinessCode enumByCode = EnumUtil.getEnumByMsg(message, BusinessCode.class);
                if (enumByCode != null) {
                    code = enumByCode.code;
                } else {
                    //未识别的枚举
                    code = 100000;
                }
            } else {
                message = e.toString();
                //未识别的枚举
                code = 100000;
            }
        } else if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            message = bindingResult.getFieldError().getDefaultMessage();
        } else {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return new RestResult<>(code, message);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmer);
    }

    public String extractMessage(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violationSet = e.getConstraintViolations();

        String field = null;
        String message = null;

        if (violationSet != null && !violationSet.isEmpty()) {
            ConstraintViolation<?> constraintViolation = violationSet.iterator().next();
            field = constraintViolation.getPropertyPath().toString();
            message = constraintViolation.getMessage();
        }

        log.error("验证错误 field={}, message={}", field, message);
        return message;
    }

}
