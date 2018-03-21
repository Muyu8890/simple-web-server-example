# simple-web-server的示例
## 前提条件
1.ide开发工具(推荐使用idea)
2.mysql数据库
## 开始
1.创建一个spring-boot的Maven项目，parent为spring-boot-starter-parent
    <parent>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-parent</artifactId>
      <version>1.5.10.RELEASE</version>
    </parent>
2.引入simple-web-server
    <dependency>
      <groupId>com.github.likeabook</groupId>
      <artifactId>simple-web-server</artifactId>
      <version>0.4</version>
    </dependency>
