package com.qianxp.eurekaclientdao.entity;

import javax.persistence.*;

@Entity
@Table(name="department")
public class Department implements java.io.Serializable{
    @Id
    // 自动生成
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
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
}
