# 请求地址
> http://<IP>:<Port>/getDbList.md

# 请求方法
> Get

# 请求头[header]
> 参数|是否必填|类型|说明
> :---:|:---:|:---:|:---:
Authorization|否|string|用户签名
myclient|否|string|客户端信息

# `POST`请求参数
base64_encode(deviceid=设备ID&client_version=客户端版本&time=客户端时间戳&token=客户端构造的token)

# 响应码
> code|说明
> :---:|:---:
0|成功
大于0|不成功

# 响应结果
```
{
    "columns": [],
    "error": null,
    "rows": [
        "Car.db-journal",
        "Car.db",
        "Contact.db-journal",
        "ExtTest.db",
        "Contact.db",
        "APP_SHARED_PREFERENCES"
    ],
    "dbVersion": 0,
    "isSuccessful": true
}
```