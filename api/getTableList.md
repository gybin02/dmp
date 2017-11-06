

# 请求地址
> http://192.168.53.203:8081/getTableList?database=Car.db

# 请求方法
> Get

# 请求头[header]
> 参数|是否必填|类型|说明
> :---:|:---:|:---:|:---:
Authorization|否|string|用户签名
myclient|否|string|客户端信息

# `Get`请求参数
database=Car.db

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
        "android_metadata",
        "cars",
        "transaction"
    ],
    "dbVersion": 1,
    "isSuccessful": true
}
```