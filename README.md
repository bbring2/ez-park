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
| ```POST```   | ```/auth/new```                  | 어드민 회원가입       |
| ```POST```   | ```/auth/acs```                  | 어드민 로그인        |
| ```POST```   | ```/auth/mobile/code```          | 전화번호 인증코드 요청하기 |
| ```GET```    | ```/auth/mobile?code=${code}```  | 전화번호 인증코드 확인하기 |
| ```POST```   | ```/auth/password```             | 비밀번호 찾기        |
| ```POST```   | ```/guest/membership```          | 멤버쉽 등록하기       |
| ```POST```   | ```/guest/in```                  | 입차하기           |
| ```POST```   | ```/guest/out```                 | 출차하기           |
| ```GET```    | ```/guest/coupon?code=${code}``` | 결제하기           |
| ```POST```   | ```/api/v1/membership```         | 멤버쉽 로그인하기      |
| ```DELETE``` | ```/api/v1/membership/{id}```    | 멤버쉽 해지하기       |
| ```PATCH```  | ```/api/v1/membership/{id}```    | 멤버쉽 정보 수정하기    |
| ```PATCH```  | ```/api/v2/admin/{id}```         | 어드민 정보 수정하기    |
| ```POST```   | ```/api/v2/coupon```             | 어드민 쿠폰 등록하기    |
| ```DELETE``` | ```/api/v2/coupon/{id}```        | 어드민 특정 쿠폰 삭제하기 |
| ```GET```    | ```/api/v2/membership```         | 멤버쉽 현황보기       |
| ```POST```   | ```/api/v2/spot```               | 주차장 장소 등록하기    |
| ```GET```    | ```/api/v2/spot```               | 주차장 장소 현황 전체보기 |
| ```GET```    | ```/api/v2/spot/{id}```          | 주차장 특정장소 상태보기  |