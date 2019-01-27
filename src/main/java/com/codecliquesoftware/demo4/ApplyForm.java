package com.codecliquesoftware.demo4;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Pattern;

@Validated
public class ApplyForm {

    @NotBlank(message = "Name cannot be blank")
    @Size(min=2, max=30, message = "City must be between 2 and 30 characters")
    private String name;

    @NotBlank(message = "State cannot be blank")
    @Size(min=2, max=2, message = "State must be 2 letters")
    private String state;
    
    @NotBlank(message = "City cannot be blank")
    @Size(min=2, max=30, message = "City must be between 2 and 30 characters")
    private String  city;

    @Pattern(regexp="^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$", message="Valid phone number required")
    @NotBlank(message = "Phone cannot be blank")
    private String phone;

    @CustomEmailValidator
    private String email;

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

    public String toString() {
        return "Application Form: " + this.name + ", " + this.phone + ", " + this.email + ", " + 
        this.city + ", " + this.state;
    }
}