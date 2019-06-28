package com.manoelcampos.server.model;

import java.io.Serializable;

/**
 *
 * @author manoelcampos
 */
public class User implements BaseEntity, Serializable {
    private long id;
    private String name;

    public User(){}

    public User(long id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
