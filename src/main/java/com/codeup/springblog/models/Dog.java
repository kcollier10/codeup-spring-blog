package com.codeup.springblog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name="dogs", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "state")}
})
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT (11) UNSIGNED")
    private long id;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String name;

    @Column(name = "state", nullable = false, columnDefinition = "char(2)")
    private String reside;

    public Dog() {
    }

    public Dog(long id, int age, String name, String reside) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.reside = reside;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReside() {
        return reside;
    }

    public void setReside(String reside) {
        this.reside = reside;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
