package com.soft.common.config;

/**
 * @ClassName AlipayConfig
 * @Description 支付宝沙箱基础配置类
 * @Author ljy
 * @Date 2020/2/13 20:41
 * @Version 1.0
 **/
public class AlipayConfig {
    //支付宝网关-沙箱环境使用
    public static String URL = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关-真实环境使用
    //public static String URL = "https://openapi.alipay.com/gateway.do";

    // 即创建应用后生成
    public static String APP_ID = "2016101400683589";

    //开发者私钥，由开发者自己生成
    public static String APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCHuMiTsXiHv1CS+VnqpiY90+iT1PZRHAFcKFb7Zoe2+1Re1/TNTlZ1CGSlJ1XKub5jRZKsL+a+Eqd2sDBBojv639nQj9yuf5on2PsNopzJLVnDyvH+WQHjZJiW/3kGNsj4oI9tB1dBIxLO1DaB3jtuVBi1wDlJRdK3pIeibgwy3jGOnPHE8wtq901KejI1XSJMrClvJfQ0f5G10GVA9Rl3dfnph/VrAm3v21Qkj6rM3HJ58/CYf/tqbl2VPrCjn+7AmuximGgD/GHRpjZtJJZ9nhDguRnPGWwsyQdAu91hWoOMEKCkur7CYyHajjmAFFjtLvLf6tdFMpxvKzCIrOnDAgMBAAECggEAe73V4hKkud+MLvR5Lp9drnFOU7qO+VR3SPbel0fb5NExE2gCIk2SNhH48Trz1WmUVB5So/rofdO0K1poJO8tkIYXqTgBFHfyrPH/s2bXW/SlKwYVrLiqKBDHrqQuS6QXh9eb7OQMga7grwJ8z9s2hFjYTp17nXqzrAuuPkHnjVgBTcvK4G9hmnYl1kSwu+swCRADutGawZab07B66y6poAy0pMLerS14XhIfjwxo1H4FVKZtQtG5IJGyWfhrRVceEiCFgH6R7gjpzR3oInSFrX1Vej4q4F1QbvPARKv/6/HDy6nKmDy3NgAtfJpnDc7kyNT63F+kJ4EpVBbmpjkHwQKBgQDUCWHLBQuv6Fm8eZlD0ONqwQAnbxAhtnmI/hU1ukEzceua0nlnjA/VCY4DLlxZ0dyen0FG8+4Eh+xOhjYQdMAAO0mR5WNS+vQqM5QhohVuwj5FHGiwg+1jDsI5NMsYDo1HMjQcQMa4uKI6Y7CNorqZWRZUuRM78G0LXqPAESAhxwKBgQCj3LabZ1PUQM79LLDHdBaK3fdKGlEpo9KzgAzVrPsrgKnZne5a8CLMZle++r31kK7lfpW589F+S6bSyZ1s4g3hQEJ6zlplsuvN0aff8Ik+AIc72RGzTLassZAC1A3Q+ijJD5kJgYBQRCBhHr7O5I6foqfNjFqjSV6ioAmaoze4JQKBgQCW4Aom9PMo+zMHKptFJxj7OFPMu3mGE5qNQQaEkYCdg507MDLU3FPTqhXT66QpAWxzriw7uYyOysz53wQPV5PbVlR2LPws6obclJD+EaAgjLTUZm+T0nwS9Uh8fjVZa9lZZL6xr+H3ROGinJbfYYBXZ429QWgPSXe+FFx+aXEstwKBgQCe8lKDbfhH1FG0Dayw3G+dZnAghmSiQpH4okZQ4omFCjo3qFV0CqmGoeONkkW/NQgh/ucXyGU24AVDRGSbIK+cBqw12YKgUa0gKbVwqS9HYFXNfOMJjGlKHLb3t2BrjK0RUzr8mIyxz1OlQaCOqe+a87lXzkSBTYMptpl6UcaTrQKBgQDTUOCkM5OOC8PvgjVP996vlBcY3DISH5FVtiaxbyR58SnxlAkTgZsRzEb36V5RaqS0bcjE3UOEaFKM5EBPFuGxWOca85mFcwFkiIgbvP8K9kaOYNVecGIU5HdDLTwfIEGAR1OsQBLFnEjvVI13XSMAyfjrmiyFT5llgTLBuZvR6Q==";

    // 参数返回格式，只支持 json
    public static String FORMAT = "json";

    // 编码集，支持 GBK/UTF-8
    public static String CHARSET = "UTF-8";

    // 支付宝公钥，由支付宝生成
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvjme7kFbZAMU9TDn6iZBvOFAGUaQu47mXNhZ7EgD6s5K3/NkVTDOCaqRAZ7qBpKwNdsYOeCl2JsugIZzEPtIbuPZhYSUgXlLg4+nTt5k4IHu6hQylTX82nLVlMAaCw7xmMc8OH99ym/mLvf/Os1UQVvvtbta+19bFzuaHn8fem8IXtIP3PN1NuHpYVTzKTtbJIwgM9yDCD5lfg9qIRWiSlnrzc+t+R5+aUwolORg/eyea0i/sMghbPyb/rUY6LPVKgZXhvIE8k0ebnVoVREGzilFb3L8fZWfsenLvEuiubjFJ4CpEOV7YbmorsC9KsKNMfFg3UMqimSCY+4y6hDYHQIDAQAB";

    // 商户生成签名字符串所使用的签名算法类型，目前支持 RSA2 和 RSA，推荐使用 RSA2
    public static String SIGN_TYPE = "RSA2";

    // 服务器异步通知页面路径
    public static String notify_url = "http://localhost:8085/alipy/return_url.html";

    // 页面跳转同步通知页面路径
    public static String return_url ="http://localhost:8085/go/return_url";

}
