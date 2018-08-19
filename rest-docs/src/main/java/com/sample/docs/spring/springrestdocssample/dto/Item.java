package com.sample.docs.spring.springrestdocssample.dto;

import java.time.LocalDateTime;

public class Item {

    private String id;

    private String name;

    private LocalDateTime dateTime;

    public Item() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
