package main.java.entity;

import javax.persistence.*;

@Entity
public class Register {

    @Id
    private int registerId;
    private String name;



    public Register() {
        super();
    }

    public Register(int registerId, String name) {
        super();
        this.registerId = registerId;
        this.name = name;
    }

    public int getRegisterId() {
        return registerId;
    }
    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Register [registerId=" + registerId + ", name=" + name + "]";
    }


}
