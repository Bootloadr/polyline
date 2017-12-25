# polyline
Application encodes location data to Polyline data

#Setup steps
1. Create mysql schema and user/pass

2. Create application.properties file in class path with below details-

#Server
server.address=127.0.0.1
server.port=9000
server.context-path=/api

#Mysql
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/yourSchema
spring.datasource.username=user
spring.datasource.password=password

#Hibernate properties

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
spring.jpa.hibernate.ddl-auto = create
