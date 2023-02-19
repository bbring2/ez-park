# EZ Park API
> This project is application which can park on offline parking lot, and be managed by admins.

## Made by
- JDK 17
- Spring boot 3.0.2
- MySQL 
- MongoDB

## Endpoints
| Method       | URI                              | Description    |
|--------------|----------------------------------|----------------|
| ```POST```   | ```/auth/new```                  | sign up as admin       |
| ```POST```   | ```/auth/acs```                  | log in as admin        |
| ```POST```   | ```/auth/mobile/code```          | request mobile verification |
| ```GET```    | ```/auth/mobile?code=${code}```  | verify mobile code |
| ```POST```   | ```/auth/password```             | forgot password        |
| ```POST```   | ```/guest/membership```          | subscribe membership       |
| ```POST```   | ```/guest/in```                  | car in           |
| ```POST```   | ```/guest/out```                 | car out           |
| ```GET```    | ```/guest/coupon?code=${code}``` | pay           |
| ```POST```   | ```/api/v1/membership```         | check in as membership      |
| ```DELETE``` | ```/api/v1/membership/{id}```    | leave membership       |
| ```PATCH```  | ```/api/v1/membership/{id}```    | edit personal info for membership    |
| ```PATCH```  | ```/api/v2/admin/{id}```         | edit admin info    |
| ```POST```   | ```/api/v2/coupon```             | register coupon    |
| ```DELETE``` | ```/api/v2/coupon/{id}```        | delete coupon |
| ```GET```    | ```/api/v2/membership```         | fetch memberships       |
| ```POST```   | ```/api/v2/spot```               | register spots for parking    |
| ```GET```    | ```/api/v2/spot```               | fetch spot status |
| ```GET```    | ```/api/v2/spot/{id}```          | search specific spot  |
