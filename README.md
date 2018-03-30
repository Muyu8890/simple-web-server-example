# simple-web-server的示例
## 前提条件
1.ide开发工具(推荐使用idea)
2.mysql数据库
3.直接clone代码，在数据库中执行第4步脚本，修改数据库连接启动即可
## 从0开始
#### 1.创建一个spring-boot的Maven项目，parent为spring-boot-starter-parent
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.10.RELEASE</version>
	</parent>
#### 2.引入simple-web-server
	<dependency>
		<groupId>com.github.likeabook</groupId>
		<artifactId>simple-web-server</artifactId>
		<version>0.4</version>
	</dependency>
#### 3.创建maven目录结构(略)
#### 4.数据库中创建表，并插入初始化数据(/src/main/sql/Init.sql中)
    drop table if EXISTS User;
    CREATE TABLE `User` (
      `userId` varchar(50) NOT NULL DEFAULT '',
      `name` varchar(50) DEFAULT NULL,
        `company` varchar(50) DEFAULT NULL,
      `creatorId` varchar(255) DEFAULT NULL,
      `creatorName` varchar(255) DEFAULT NULL,
      `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
      `modifierId` varchar(255) DEFAULT NULL,
      `modifierName` varchar(255) DEFAULT NULL,
      `modifyTime` datetime DEFAULT CURRENT_TIMESTAMP,
      `deleteFlag` tinyint(1) NOT NULL DEFAULT '0',
      PRIMARY KEY (`userId`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
    
    INSERT INTO `User`(`userId`, `name`, `company`, `creatorId`, `creatorName`, `createTime`, `modifierId`, `modifierName`, `modifyTime`, `deleteFlag`) VALUES ('userId1', '张三', '阿里巴巴', NULL, NULL, '2018-03-21 14:42:14', NULL, NULL, '2018-03-21 14:42:14', 0);
    INSERT INTO `User`(`userId`, `name`, `company`, `creatorId`, `creatorName`, `createTime`, `modifierId`, `modifierName`, `modifyTime`, `deleteFlag`) VALUES ('userId2', '李四', '阿里巴巴', NULL, NULL, '2018-03-21 14:42:14', NULL, NULL, '2018-03-21 14:42:14', 0);
    INSERT INTO `User`(`userId`, `name`, `company`, `creatorId`, `creatorName`, `createTime`, `modifierId`, `modifierName`, `modifyTime`, `deleteFlag`) VALUES ('userId3', '王五', '阿里巴巴', NULL, NULL, '2018-03-21 14:42:14', NULL, NULL, '2018-03-21 14:42:14', 0);
    INSERT INTO `User`(`userId`, `name`, `company`, `creatorId`, `creatorName`, `createTime`, `modifierId`, `modifierName`, `modifyTime`, `deleteFlag`) VALUES ('userId4', '李四', '腾讯', NULL, NULL, '2018-03-21 14:42:14', NULL, NULL, '2018-03-21 14:42:14', 0);
    INSERT INTO `User`(`userId`, `name`, `company`, `creatorId`, `creatorName`, `createTime`, `modifierId`, `modifierName`, `modifyTime`, `deleteFlag`) VALUES ('userId5', '王七', '腾讯', NULL, NULL, '2018-03-21 14:42:14', NULL, NULL, '2018-03-21 14:42:14', 0);
    
#### 5.创建实体类(User)，继承BaseEntity<User>，根据业务需要是否继承，泛型不能少
	package com.jeecode.user;
	import com.github.likeabook.webserver.entity.BaseEntity;
	import javax.persistence.Id;
	import javax.persistence.Table;
	@Table(name = "User")
	public class User extends BaseEntity<User> {
		@Id
		public String userId;
		public String name;
		public String company;
		// get set 要补全
	}
	
#### 6.创建Mapper接口类(没有实现类)，继承BaseMapper<User>，需要@Mapper注解，泛型不能少
	package com.jeecode.user;
	import com.github.likeabook.webserver.mapper.BaseMapper;
	import org.apache.ibatis.annotations.Mapper;
	@Mapper
	public interface UserMapper extends BaseMapper<User> {
	}
	
#### 7.创建Service类，继承BaseService<User>，需要@Service注解，泛型不能少。注入UserMapper变量为mapper，或者实现getMapper方法，返回类型为UserMapper
	package com.jeecode.user;
	import com.github.likeabook.webserver.service.BaseService;
	import org.springframework.stereotype.Service;
	import javax.annotation.Resource;
	@Service
	public class UserService extends BaseService<User> {
		@Resource
		private UserMapper mapper;
	}
	
#### 8.创建Controller类
	package com.jeecode.user;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import javax.annotation.Resource;
	@RestController
	@RequestMapping("user")
	public class UserController {
		@Resource
		private UserService userService;
		@RequestMapping("get")
		public User get(User paramUser){
			return userService.find(paramUser);
		}
	}
	
#### 9.创建启动类，@SpringBootApplication为spring-boot注解，@ImportSimpleWebServerBean为simple-web-server注解
	package com.jeecode;
	import com.github.likeabook.webserver.ImportSimpleWebServerBean;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	@SpringBootApplication
	@ImportSimpleWebServerBean
	public class MainApplication {
		public static void main(String[] args) {
			SpringApplication.run(MainApplication.class, args);
		}
	}
	
#### 10.rescues目录下创建application.properties文件
	spring.datasource.driverClassName=com.mysql.jdbc.Driver
	spring.datasource.url=jdbc:mysql://localhost:3306/core?useUnicode=true&characterEncoding=utf-8
	spring.datasource.username=root
	spring.datasource.password=123456
	
	logging.level.root=debug
	
#### 10.运行MainApplication，浏览器访问 http://localhost:2222/user/get?userId=userId1 结果如下
    {
        "errorCode": 0,
        "message": "操作成功",
        "result": {
            "deleteFlag": false,
            "creatorId": null,
            "creatorName": null,
            "createTime": 1521614534000,
            "modifierId": null,
            "modifierName": null,
            "modifyTime": 1521614534000,
            "userId": "userId1",
            "name": "张三",
            "company": "阿里巴巴"
        }
    }
## 更多功能请看 MoreExampleController 类

