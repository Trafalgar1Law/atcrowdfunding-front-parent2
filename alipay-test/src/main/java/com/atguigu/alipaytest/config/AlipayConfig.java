package com.atguigu.alipaytest.config;

public class AlipayConfig {
    public static String app_id = "2016101100661020";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCPgm/k4k0qk45SufP0TJ9RbrSauX94QUyxA8B9busHVIl3F0Etqa/IbrTqF6JQKEhESdMDBLI3mlnSeL12PtumihtgWduBDZpnWLj4A1sMn0bcKbZ5cO2io+XbtdzKQHpnnaVDaz+50pHFG811gN8EElog6+sw2C23/45O7vdXvMs8sM5hHa7a/JnkVobiiKqru1ussyaRY8bqNvHI7EGoW4n5xXfzdSdZeiWKIBl/frOEevNU2MfoqgwtR+5vw8DaybfNH/uFS5Ndl7AST+sjHDdrtEY72UOpE4kHsq4swyqzH4C+ubddrxUbQND86/8pPgc5vODv2fwfttsCvSoXAgMBAAECggEAXxisVRuwztngoekfQ2/S0v9tJmptkZ6T12kJERWDIORgA06hnkSne0YBFG583GkVGkthTMq73iSmCNaBle2pV/6EjaB92FLPUlR0ncR7fS2+ov3xMSAoGHJLSwCEQnHfqvHIJZjYLabfeaIm0AqJvgT7PH2Y6FEYWqk6AAxSUwyFR6q29muror7be602UTBvl9kmfKa68dkNIrdv+CLWxLUDBFz2kY1b3m+JzAXzhoKPAaHpttBQ+oLhX2zwhGUV+XmpedYA9sgzpVV3/H93o8/Fr3lNHs8q1M/krrv50WdvEAOHWosQKprVrmabggOcrjtYaQuqKXS9S5e/SH6F4QKBgQDPEMAVkYxbpT1+duPyHW4KCtd+LjfwX4Azq215+Z63/vB7gfrWU/8+LnOeqt2l44KmcGqDGVOO7H56O9XCe7ApV56Yo2iWms/z8wkgn5dnIaEOapyks6p3N2YSbLxbIQ8aNzlTK6FEze2PGtc2PzKeo0/wNuDkMlcRnkFeHD+LXQKBgQCxbJ5F+R9UrmMKY2wb0VlX+qbmKR4BWbDWru0yxbCHqQTFdVzsYL19MynxB0xzrWW5cQ4tvBYMMP0Sje2J6K2lDiuZeLXAL8aFC6rZAPpHAq/l7Pw0bho6UtHiavNxyPFwPhswG+NayKiZNh/WWIby3mY169h0fiMGzIFs9ZgoAwKBgAjEhc2j/xR2V7c+I4LB+kHUmbFPFbFI6e3GKXmLt0vFMLuaElv27IzefKjQRVhb3NFdWzU34lDf9K8KT4/PmvL1MdL2wFv4LCwBM3a9KzUDuIUawI08ylAH+Xt4PTWCndgXVIcQBuEZ8yAnG8vBO0x6T801Faqz8vndAJmSiqJFAoGAF4zeWVVe9kOLe+aEhBC+tjHcE3Lju7QnB+gCLhoVe3xQ2NDiO7H/lO3EpGyelkAu33WFN0be+lFKVjsmi4ap/d2qpd1i6pas2B4bWGCL1/8gT/mr5F2094bkuxQNKk5M1eQ4gaNCA1vdHTEU+sOXbgddM80RVy0jAxUEHO1ge/cCgYAghpEEkYtrWNV7Q8rIf1jv8H2U0ktRMuRV+VVL9aiSazGvc91pSzubhdqDgNEZu7uPBlbaIHZBqHRYqqYFF31uXfSQqLCPd8g9DBgLuJjWRHIDBkAGqB/BLxUnw9C0qXmBgD2WaGwVx/mS931X6MqOkhv1E4f9a+fny1qpktYWGg==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnGx4MCFiKpbXL4GZjvoKZaWw5pvSRgLKP/OlVlqx62O2CEeoJhR47mBcquY9/Iwp8GwakWnK9ZLZKE4LozdfwT+E5jTOyu/adI5kTX8Noy6LfvgFZYC7hQHnMOwR3kQZM8BtcNAAGl9Mlo/C5EYRsOW5mqVo8Ieffqd1X/OJP4LH0m6tvCa/E9bYX/2ll3Onz7uw2QTVzSlPOL2cVQgiPSQG4DMgkx3xOBjBoJz4OC1Qa6T+oAIDxvyEN1a/k51IjOtgrItfYcSCgskUnCjkVWVgpQzhi0ArIuD3A7y9OJ7SV7W7As0VyQvcs0O0dPKOztYQj+9Ac39IK50cGsXfVwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://1eyr0zamta.52http.net/payAsync";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://1eyr0zamta.52http.net/orderList";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "UTF-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";
}
