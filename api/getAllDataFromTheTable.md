
# 请求地址
> http://192.168.53.203:8081/getAllDataFromTheTable?tableName=cars

# 请求方法
> GET

# 请求头[header]
> 参数|是否必填|类型|说明
> :---:|:---:|:---:|:---:
Authorization|否|string|用户签名
myclient|否|string|客户端信息

# `GET`请求参数
tableName=cars

# 响应码
> code|说明
> :---:|:---:
0|成功
大于0|不成功

# 响应结果
```
{
    "errorMessage": null,
    "rows": [
        [
            {
                "dataType": "integer",
                "value": 1
            },
            {
                "dataType": "text",
                "value": "name_0"
            },
            {
                "dataType": "text",
                "value": "RED"
            },
            {
                "dataType": "real",
                "value": 10.449999809265137
            }
        ],
        [
            {
                "dataType": "integer",
                "value": 2
            },
            {
                "dataType": "text",
                "value": "name_1"
            },
            {
                "dataType": "text",
                "value": "RED"
            },
            {
                "dataType": "real",
                "value": 11.449999809265137
            }
        ],
        [
            {
                "dataType": "integer",
                "value": 3
            },
            {
                "dataType": "text",
                "value": "name_2"
            },
            {
                "dataType": "text",
                "value": "RED"
            },
            {
                "dataType": "real",
                "value": 12.449999809265137
            }
        ],
        [
            {
                "dataType": "integer",
                "value": 4
            },
            {
                "dataType": "text",
                "value": "name_3"
            },
            {
                "dataType": "text",
                "value": "RED"
            },
            {
                "dataType": "real",
                "value": 13.449999809265137
            }
        ],
        [
            {
                "dataType": "integer",
                "value": 5
            },
            {
                "dataType": "text",
                "value": "name_28"
            },
            {
                "dataType": "text",
                "value": "RED"
            },
            {
                "dataType": "real",
                "value": 58.45000076293945
            }
        ],
        [
            {
                "dataType": "integer",
                "value": 50
            },
            {
                "dataType": "text",
                "value": "name_49"
            },
            {
                "dataType": "text",
                "value": "RED"
            },
            {
                "dataType": "real",
                "value": 59.45000076293945
            }
        ]
    ],
    "tableInfos": [
        {
            "title": "id",
            "isPrimary": true
        },
        {
            "title": "name",
            "isPrimary": false
        },
        {
            "title": "color",
            "isPrimary": false
        },
        {
            "title": "mileage",
            "isPrimary": false
        }
    ],
    "isEditable": true,
    "isSelectQuery": true,
    "isSuccessful": true
}
```