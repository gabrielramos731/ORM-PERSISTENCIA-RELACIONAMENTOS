package com.mycompany.orm.persistencia.com.relacionamentos.user;

import com.mycompany.orm.persistencia.com.relacionamentos.entity.Entity;

import java.time.LocalDate;

public class User extends Entity {
    
    private String name;
    private String email;
    private LocalDate birthdate;
    
    //<editor-fold defaultstate="collapsed" desc="cronstructors">
    
    public User(){}
    
    public User(String name, String email, LocalDate birthdate) throws Exception {
        setName(name);
        setEmail(email);
        setBirthdate(birthdate);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    
    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalAccessException{
        if(name.length() < 150 && name != null) this.name = name;
        else throw new IllegalAccessException("Tamanho de nome inválido");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalAccessException{
        if(email.length() < 255 && email != null) this.email = email;
        else throw new IllegalAccessException("Tamanho de email inválido");
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) throws IllegalAccessException{
        if(birthdate != null) this.birthdate = birthdate;
        else throw new IllegalAccessException("Tamanho de email inválido");
    }
    //</editor-fold>
}
