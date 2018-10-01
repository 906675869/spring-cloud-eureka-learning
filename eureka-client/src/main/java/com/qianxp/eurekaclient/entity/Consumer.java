package com.qianxp.eurekaclient.entity;

public class Consumer {
    // ID
    private int id;
    // name
    private String name;
    // action
    private String action;
    // address
    private String address;
    // toString
    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", action='" + action + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Consumer() {
    }

    public Consumer(int id, String name, String action, String address) {
        this.id = id;
        this.name = name;
        this.action = action;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
