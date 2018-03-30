package com.jeecode.user;
import com.github.likeabook.webserver.query.Page;
import com.github.likeabook.webserver.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@RestController
public class MoreExampleController {
    @Resource
    private UserService userService;
    @RequestMapping("example")
    public void example(){
        // 根据id获取一条记录
        // select t.* from User t where 1=1 and (t.userId = ?)
        //  userId1(String)
        User user = userService.get(User.class, "userId1");

        // 根据条件查询一条记录
        // select t.* from User t where 1=1 and t.name = ?
        //  张三(String)
        User user2 = userService.find(new User().setName("张三"));

        // 根据条件想要查询一条记录，实际存在多条会报错
//        User user3 = userService.find(new User().setName("李四"));

        // 根据条件查询一条记录-查询叫李四同时公司是在阿里巴巴的-对象参数方式
        //  select t.* from User t where 1=1 and t.name = ? and t.company = ?
        //   李四(String), 阿里巴巴(String)
        User user4 = userService.find(new User().setName("李四").setCompany("阿里巴巴"));

        // 根据条件查询一条记录-查询叫李四同时公司是在阿里巴巴的-Query方式
        //  select t.* from User t where 1=1 and t.name = ? and (company = ?)
        //   李四(String), 阿里巴巴(String)
        User paramUser5 = new User();
        paramUser5.setName("李四");
        Query query5 = new Query();
        query5.addWhere("company = #{company}").addParam("company", "阿里巴巴");
        User user5 = userService.find(paramUser5, query5);

        // 根据条件查询多条记录-查询所有叫李四的人
        //  select t.* from User t where 1=1 and t.name = ?
        // 李四(String)
        List<User> userList6 = userService.findList(new User().setName("李四"));

        // 查询所有姓王的人
        // select t.* from User t where 1=1 and (name like concat('%', ?, '%'))
        // 王(String)
        Query query7 = new Query();
        query7.addWhere("name like concat('%', #{name}, '%')").addParam("name", "王");
        List<User> userList7 = userService.findList(new User(), query7);

        // in
        // select t.* from User t where 1=1 and userId in (?, ?)
        // userId1(String), userId2(String)
        Query query8 = new Query();
        List<String> userIdList8 = new ArrayList<>();
        userIdList8.add("userId1");
        userIdList8.add("userId2");
        query8.addIn("userId", userIdList8);
        query8.addNotIn("userId", "userId1");
        List<User> userList8 = userService.findList(new User(), query8);

        // 查询分页
        // select count(1) from User t where 1=1 and t.company = ?
        // 阿里巴巴(String)
        // select t.* from User t where 1=1 and t.company = ? limit 0, 20
        // 阿里巴巴(String)
        Page<User> userList9 = userService.findPage(new User().setCompany("阿里巴巴"), new Query().setPageNo(1).setPageSize(20));

        // 还有 save saveBatch update updateNotNull delete

        // 通过上面的示例可以看到，灵活实现了我们想要的功能而不用在userService添加任何方法



        Page<User> userList10 = userService.findPage(new User().setCompany("阿里巴巴"), new Query().addIn("userId", "userId1").setPageNo(1).setPageSize(20));
        List<User> userList11 = userService.findList(new User().setCompany("阿里巴巴"), new Query().addIn("userId").setPageNo(1).setPageSize(20));

        System.out.println();
    }
}
