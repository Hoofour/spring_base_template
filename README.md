# 📁 Cấu trúc thư mực được tạo sẵn trong base template này:

src\main\java\com\ra\spring_base_template
├── advice
│ └── GlobalHandleException.java
│
├── config
│ └── CloudinaryConfig.java
│
├── controller
│
├── dto
│ ├── request
│ ├── response
│ │ └── JwtResponse.java
│ └── ResponseWrapper.java
│
├── exception
│ ├── GlobalExceptionHandler.java
│ ├── HttpBadRequest.java
│ ├── HttpConflict.java
│ ├── HttpForbiden.java
│ ├── HttpNotFound.java
│ ├── HttpUnAuthorized.java
│ └── ResourceNotFoundException.java
│ 
├── model
│ ├── base
│ │ └── BaseObject.java
│ └── constants
│
├── repository
│
├── scheduler
│
├── security
│ ├── exception
│ │ ├── AccessDenied.java
│ │ └── JwtEntryPoint.java
│ │
│ ├── jwt
│ │ ├── jwtProvider.java
│ │ └── JwtTokenFilter.java
│ │
│ ├── principle
│ │ ├── MyUserDetails.java
│ │ └── MyUserDetailsService.java
│ │
│ └── SecurityConfig.java
│
├── sevices
│ └── impl
│ 
├── swagger
│ 
├── utils
│ └── FileUploadUtil.java

---
# Các bước khi clone code base về cần làm :
# Bước 1:
- vào file application.yml dán các key cũng như cấu hình cần thiết vào
# Bước 2: 
- vào thư mục model và constants được tạo sẵn khi clone project về ( User , Role) chỉnh lại cho phù hợp với project




