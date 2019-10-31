package com.yyx.mutilrecyclerview.bean;

public class DataBean {
    private int id;
    private String name;
    private int type;
    private int imageResource;

    public DataBean(int id, String name, int type, int imageResource) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imageResource = imageResource;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
