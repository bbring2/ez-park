# Student System APIs
> This repository has been made this application connected to Mongodb(NoSQL).

## About This APIs
- In order to manage students, It has been made.
- Following URI versioning method, This API can be managed by authorization.
- By using Spring security, Authentication has been made for users.
- You can also check requirements about this APIs.
- Following REST API rules, 

## End points
| method | URI                         | description                        |
|--------|-----------------------------|------------------------------------|
| POST   | ``` /guest/sign-up```       | sign up for new users              |
| POST   | ``` /guest/log-in```        | log in who already signed up       |
| POST   | ``` /guest/google```        | sign up or log in for oauth2 users |
| GET    | ``` /guest/missing```       | to get temporary password          |




## Requirements



## About mongodb
### Collections
-  Mongo stores documents (rows) in collections(table).
### Documents
- MongoDB stores data records as BSON documents. BSON is Binary representation of JSON Documents.
- As you can see the below codes which look like JSON, those can be documents on MongoDB.
```json
{
  "name": "bbring",
  "age": 27,
  "status": "A",
  "groups": ["java", "python"]
}
```

### BSON Types
| Type               | Alias      |
|--------------------|------------|
| Double             | double     |
| String             | string     |
| Object             | object     |
| Array              | array      |
| Binary data        | binData    |
| ObjectId           | objectId   |
| Boolean            | bool       |
| Date               | date       |
| Null               | null       |
| Regular Expression | regex      |
| Javascript         | javascript |
| 32 Big integer     | int        |
| 64 bit integer     | long       |
| Decimal128         | decimal    |
| Min Key            | minKey     |
| Max Key            | maxKey     |
   
