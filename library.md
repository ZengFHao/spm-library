---
title: library v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.17"

---

# library

> v1.0.0

Base URLs:

* <a href="http://test-cn.your-api-server.com">测试环境: http://test-cn.your-api-server.com</a>

# 示例项目/manager

## POST 借书

POST /managerop/bookBorrowInfo

> Body 请求参数

```json
{
  "id": "1",
  "name": "test",
  "isbn": "978-12345",
  "date": "10",
  "account": "zengfanhao"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|

> 返回示例

> 成功

```json
{
  "status": true,
  "op": "Borrow book",
  "msg": {
    "code": "110",
    "content": "Borrow book successfully!"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» status|boolean|true|none||none|
|» op|string|true|none||none|
|» msg|object|true|none||none|
|»» code|string|true|none||none|
|»» content|string|true|none||none|

## POST admin登录

POST /managerop/login

> Body 请求参数

```json
{
  "account": "zhaozhao",
  "password": "zfh"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|

> 返回示例

> 成功

```json
{
  "status": true,
  "op": "Login",
  "msg": {
    "code": "101",
    "content": "Login successfully!"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» status|boolean|true|none||none|
|» op|string|true|none||none|
|» msg|object|true|none||none|
|»» code|string|true|none||none|
|»» content|string|true|none||none|

## POST admin修改密码

POST /managerop/changepassword

> Body 请求参数

```json
{
  "account": "zengfanhao",
  "target": "zhaozhao",
  "newpswd": "zfh"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|account|query|string| 否 |管理员用户名|
|target|query|string| 否 |待修改用户名|
|newpswd|query|string| 否 |新密码|
|body|body|object| 否 |none|

> 返回示例

> 成功

```json
{
  "status": true,
  "op": "Change password",
  "msg": {
    "code": "102",
    "content": "Changed successfully!"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» status|boolean|true|none||none|
|» op|string|true|none||none|
|» msg|object|true|none||none|
|»» code|string|true|none||none|
|»» content|string|true|none||none|

## POST 按书名查找

POST /managerop/getbook/byname

> Body 请求参数

```json
{
  "name": "test"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|

> 返回示例

> 成功

```json
{
  "status": false,
  "op": "Get book by name",
  "msg": {
    "code": "014",
    "content": "There's no book with the name: [test1]."
  },
  "books": []
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» status|boolean|true|none||none|
|» op|string|true|none||none|
|» msg|object|true|none||none|
|»» code|string|true|none||none|
|»» content|string|true|none||none|
|» books|[string]|true|none||none|

## POST 按种类查找

POST /managerop/getbook/bycategory

> Body 请求参数

```json
{
  "category": "math"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|

> 返回示例

> 成功

```json
{
  "status": true,
  "op": "Get book by category",
  "msg": {
    "code": "109",
    "content": "Get book successfully!"
  },
  "books": [
    {
      "id": 1,
      "name": "test",
      "author": "spread",
      "pulisher": "spread",
      "summary": "haha",
      "cover": "test.jpg",
      "price": 2.22,
      "stock": 29,
      "category": "math",
      "isbn": "978-12345"
    },
    {
      "id": 3,
      "name": "haha",
      "author": "asudgf",
      "pulisher": "asklgdf;",
      "summary": "uududu",
      "cover": "hehe.png",
      "price": 11.11,
      "stock": 33,
      "category": "math",
      "isbn": "978-23129"
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» status|boolean|true|none||none|
|» op|string|true|none||none|
|» msg|object|true|none||none|
|»» code|string|true|none||none|
|»» content|string|true|none||none|
|» books|[object]|true|none||none|
|»» id|integer|true|none||none|
|»» name|string|true|none||none|
|»» author|string|true|none||none|
|»» pulisher|string|true|none||none|
|»» summary|string|true|none||none|
|»» cover|string|true|none||none|
|»» price|number|true|none||none|
|»» stock|integer|true|none||none|
|»» category|string|true|none||none|
|»» isbn|string|true|none||none|

# 示例项目/user

## POST user登录

POST /userop/login

> Body 请求参数

```yaml
account: zhaozhao
password: zcbzcbzcb
type: "2"

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» account|body|string| 否 |用户名|
|» password|body|string| 否 |用户密码|
|» type|body|integer| 否 |账号类型（type： user == 2）|

> 返回示例

> 成功

```json
{
  "status": false,
  "op": "Login",
  "msg": {
    "code": "023",
    "content": "Account type mismatch"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» status|boolean|true|none||none|
|» op|string|true|none||none|
|» msg|object|true|none||none|
|»» code|string|true|none||none|
|»» content|string|true|none||none|

## POST user修改密码

POST /userop/changepassword

> Body 请求参数

```yaml
account: zhaozhao
oldpswd: zfh
newpswd: zfh1

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» account|body|string| 否 |用户名|
|» oldpswd|body|string| 否 |旧密码|
|» newpswd|body|string| 否 |新密码|

> 返回示例

> 成功

```json
{
  "status": false,
  "op": "Change password",
  "msg": {
    "code": "024",
    "content": "Old password is wrong"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» status|boolean|true|none||none|
|» op|string|true|none||none|
|» msg|object|true|none||none|
|»» code|string|true|none||none|
|»» content|string|true|none||none|

# 示例项目/Public

## GET 获取所有书籍种类

GET /managerop/getallcat

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|ddasdasd|query|string| 否 |sadasdasd|

> 返回示例

> 成功

```json
{
  "status": true,
  "op": "Get all categories",
  "msg": {
    "code": "103",
    "content": "Successfully get all categories!"
  },
  "categories": [
    {
      "id": 10,
      "pid": 0,
      "name": "novel",
      "deepest": false
    },
    {
      "id": 11,
      "pid": 10,
      "name": "urban novel",
      "deepest": true
    },
    {
      "id": 12,
      "pid": 0,
      "name": "teaching material",
      "deepest": true
    },
    {
      "id": 13,
      "pid": 12,
      "name": "math",
      "deepest": true
    },
    {
      "id": 14,
      "pid": 0,
      "name": "reference book",
      "deepest": false
    },
    {
      "id": 15,
      "pid": 14,
      "name": "encyclopedia",
      "deepest": true
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» status|boolean|true|none||none|
|» op|string|true|none||none|
|» msg|object|true|none||none|
|»» code|string|true|none||none|
|»» content|string|true|none||none|
|» categories|[object]|true|none||none|
|»» id|integer|true|none||none|
|»» pid|integer|true|none||none|
|»» name|string|true|none||none|
|»» deepest|boolean|true|none||none|

## POST login

POST /login

> Body 请求参数

```json
{
  "account": "zhaozhao",
  "password": "zfh1"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» account|body|string| 是 |none|
|» password|body|string| 是 |none|

> 返回示例

> 成功

```json
{
  "status": true,
  "op": "Login",
  "msg": {
    "code": "101",
    "content": "Login successfully!"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» status|boolean|true|none||none|
|» op|string|true|none||none|
|» msg|object|true|none||none|
|»» code|string|true|none||none|
|»» content|string|true|none||none|

# 数据模型
