package com.qianxp.eurekaclientdao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User implements java.io.Serializable{
    @Id
    // 自动生成
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //保证存取时能够提供正确的格式避免保存失败
    private Date createdate;
    @ManyToOne
    @JoinColumn(name="did")
    @JsonBackReference // 防止关系对象递归访问
    private Department department;
    @ManyToMany(cascade = {},fetch = FetchType.EAGER)
    @JoinTable(name="user_roles",joinColumns = {@JoinColumn(name = "user_id")},
                inverseJoinColumns = {@JoinColumn(name="roles_id")})
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

