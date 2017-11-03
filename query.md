# 请求地址
> http://test-users.seeyouyima.com/nologin

# 请求方法
> POST

# 请求头[header]
> 参数|是否必填|类型|说明
> :---:|:---:|:---:|:---:
Authorization|否|string|用户签名
myclient|是|string|客户端信息

# `GET`请求参数

# 响应码
> code|说明
> :---:|:---:
0|成功
大于0|不成功

# 响应结果
```
{
  "authentication_token": "3.qVBpbphrp4z5XRTF9WOmKAzg1uPfA/CHJC6Tye6xSGY=",
  "user_id": "105029610",
  "platform": 9
}
```