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

## POST 借书信息

POST /managerop/bookBorrowInfo

> Body 请求参数

```json
{
  "id": "1",
  "page": "1",
  "num": "1"
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
  "op": "Get borrow info",
  "msg": {
    "code": "112",
    "content": "Get borrowInfo successfully!"
  },
  "list": [
    {
      "bookIsbn": "978-12345",
      "bookName": "test",
      "bookAuthor": "spread",
      "borrowAccount": "zengfanhao",
      "borrowTime": "2023-04-20 08:47:28",
      "borrowDuration": 10,
      "borrowIsOverTime": 0
    },
    {
      "bookIsbn": "978-12345",
      "bookName": "test",
      "bookAuthor": "spread",
      "borrowAccount": "zengfanhao",
      "borrowTime": "2023-04-20 08:48:57",
      "borrowDuration": 10,
      "borrowIsOverTime": 0
    },
    {
      "bookIsbn": "978-12345",
      "bookName": "test",
      "bookAuthor": "spread",
      "borrowAccount": "zengfanhao",
      "borrowTime": "2023-04-20 08:48:16",
      "borrowDuration": 10,
      "borrowIsOverTime": 0
    },
    {
      "bookIsbn": "978-12345",
      "bookName": "test",
      "bookAuthor": "spread",
      "borrowAccount": "zengfanhao",
      "borrowTime": "2023-04-20 04:32:23",
      "borrowDuration": 10,
      "borrowIsOverTime": 0
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
|» list|[object]|true|none||none|
|»» bookIsbn|string|true|none||none|
|»» bookName|string|true|none||none|
|»» bookAuthor|string|true|none||none|
|»» borrowAccount|string|true|none||none|
|»» borrowTime|string|true|none||none|
|»» borrowDuration|integer|true|none||none|
|»» borrowIsOverTime|integer|true|none||none|

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

## POST 添加书籍种类

POST /managerop/addcategory

> Body 请求参数

```json
{
  "name": "science",
  "pname": "teaching material"
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
  "op": "Add category",
  "msg": {
    "code": "104",
    "content": "Add category [science] successfully!"
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

## POST 删除书籍种类

POST /managerop/deletecategory

> Body 请求参数

```json
{
  "name": "science1"
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
  "op": "Delete category",
  "msg": {
    "code": "105",
    "content": "Successfully deleted category [science1]."
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

## POST 添加书籍

POST /managerop/addbook

> Body 请求参数

```json
{
  "ISBN": "111-1111",
  "name": "haha",
  "author": "zfh",
  "publisher": "xdu",
  "summer": "hehe",
  "cover": "xxx.jpg",
  "price": "100",
  "stock": "10",
  "category": "novel"
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
  "op": "Add book",
  "msg": {
    "code": "106",
    "content": "Successfully added book!"
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

## POST 获取所有书籍种类

POST /getallcat

> Body 请求参数

```json
{
  "page": "2",
  "num": "3"
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
  "password": "zfh"
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

## POST 通过token登录

POST /getstatus

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": true,
  "op": "Get account status",
  "msg": {
    "code": "112",
    "content": "Get user status successfully!"
  },
  "accounts": [
    {
      "name": "zhaozhao",
      "password": "zfh",
      "type": 2
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
|» accounts|[object]|true|none||none|
|»» name|string|false|none||none|
|»» password|string|false|none||none|
|»» type|integer|false|none||none|

# 数据模型

