# springbootsecurity

https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.2.6.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.rkb&artifactId=springbootsecurity&name=springBootSecurity&description=Demo%20project%20for%20Spring%20Boot&packageName=com.rkb.springbootsecurity&dependencies=web,security,thymeleaf

Spring security create FilterChainProxy which is entry point point of all web based security
In spring.factories class look for 
org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration

Principal will be injected for us by Spring Security

Security will pass UserDetailsService which will hold UserDetails data.

The request that comes in get converted to Authentication object so it is created automatcially which is passed to AuthenticationManager


InitializingBean is a callback interface. When Spring sees this interface in an object it's going to call afterPropertiesSet()  method on the lambda. It will give us a chance to initialize the database.
