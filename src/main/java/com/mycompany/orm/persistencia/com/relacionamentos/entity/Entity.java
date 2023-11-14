package com.mycompany.orm.persistencia.com.relacionamentos.entity;

public class Entity {
    private Long id;

    //<editor-fold defaultstate="collapsed" desc="constructors">
    
    public Entity() {}
    public Entity(Long id) {
        this.id = id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //</editor-fold>
}
