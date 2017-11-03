
# 请求地址
> http://192.168.53.203:8081/updateTableData?dbName=Car.db&tableName=cars&updatedData=%255B%257B%2522title%2522%253A%2522id%2522%252C%2522isPrimary%2522%253Atrue%252C%2522value%2522%253A%25224%2522%252C%2522dataType%2522%253A%2522integer%2522%257D%252C%257B%2522title%2522%253A%2522name%2522%252C%2522isPrimary%2522%253Afalse%252C%2522value%2522%253A%2522name_3%2522%252C%2522dataType%2522%253A%2522text%2522%257D%252C%257B%2522title%2522%253A%2522color%2522%252C%2522isPrimary%2522%253Afalse%252C%2522value%2522%253A%2522RED%2522%252C%2522dataType%2522%253A%2522text%2522%257D%252C%257B%2522title%2522%253A%2522mileage%2522%252C%2522isPrimary%2522%253Afalse%252C%2522value%2522%253A%252213.449999809265137%2522%252C%2522dataType%2522%253A%2522real%2522%257D%255D


# 请求方法
> GET

# 请求头[header]
> 参数|是否必填|类型|说明
> :---:|:---:|:---:|:---:
Authorization|否|string|用户签名
myclient|否|string|客户端信息

# `GET`请求参数
base64_encodedbName=Car.db&tableName=cars&updatedData=

# 响应码
> code|说明
> :---:|:---:
0|成功
大于0|不成功

# 响应结果
```
{"isSuccessful":true}
```