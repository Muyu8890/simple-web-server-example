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

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public User setCompany(String company) {
        this.company = company;
        return this;
    }
}
