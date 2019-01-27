
package com.codecliquesoftware.demo4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name= "User")
@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String name;

    private String state;

    private String  city;

    private String phone;

    private String email;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
