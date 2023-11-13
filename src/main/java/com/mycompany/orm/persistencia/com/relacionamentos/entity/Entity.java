package com.mycompany.orm.persistencia.com.relacionamentos.entity;

public class Entity {
    private Long id;

    public Entity() {}
    public Entity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
