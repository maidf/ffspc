#### springcloud
先将common包安装到本地
```
cd common
./mvnw clean install
```
然后启动每一个小服务
```
cd services/service-xxx
./mvnw spring-boot:run
```