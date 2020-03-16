var url = window.location.href
var arry = url.split('//')
var host = arry[1].split('/')[0].split(':')[0]
// var port = arry[1].split('/')[0].split(':')[1]
window.serverPort = {
    serverConf: {
        // host: host,
        host: '47.114.84.113',
        port: '8000',
        path: '/'
    }
}
// 是否显示公司logo等 true：显示  false：隐藏
window.showFirmLogo = true
