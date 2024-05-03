package org.example.api;

import java.util.Date;

public class PriceQueriedResponse {
    private Long id;
    private String name;
    private Integer age;
    private Date greetingDate;

    public PriceQueriedResponse(Long id, String name, Integer age, Date greetingDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.greetingDate = greetingDate;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getGreetingDate() {
        return greetingDate;
    }

    public void setGreetingDate(Date greetingDate) {
        this.greetingDate = greetingDate;
    }

}
