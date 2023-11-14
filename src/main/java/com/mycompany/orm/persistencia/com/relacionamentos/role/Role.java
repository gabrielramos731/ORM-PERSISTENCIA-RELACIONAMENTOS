package com.mycompany.orm.persistencia.com.relacionamentos.role;

public class Role {
    
    private String name;

    //<editor-fold defaultstate="collapsed" desc="constructors">
    
    public Role() {}

    public Role(String name) throws Exception{
        this.name = name;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    
    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalAccessException{
        if(name.length() < 20 && name != null) this.name = name;
        else throw new IllegalAccessException("Tamanho de nome inválido");
    }
    //</editor-fold>
}
