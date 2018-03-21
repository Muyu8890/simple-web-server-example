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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
