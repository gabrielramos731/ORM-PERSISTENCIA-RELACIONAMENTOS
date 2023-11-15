package com.mycompany.orm.persistencia.com.relacionamentos.credential;

import com.mycompany.orm.persistencia.com.relacionamentos.entity.Entity;

import java.time.LocalDate;

public class Credential extends Entity {
    
    private String username;
    private String password;
    private LocalDate lastAccess;
    private boolean enabled;
    private Long userId;

    //<editor-fold defaultstate="collapsed" desc="constructors">
    
    public Credential() {}

    public Credential(Long id, String username, String password, LocalDate lastAccess, boolean enabled) throws Exception{
        setId(id);
        setUsername(username);
        setPassword(password);
        this.lastAccess = lastAccess;
        this.enabled = enabled;
    }
    
    public Credential(Long id, String username, String password, LocalDate lastAccess, boolean enabled, Long userId) throws Exception{
        setId(id);
        setUsername(username);
        setPassword(password);
        this.lastAccess = lastAccess;
        this.enabled = enabled;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    
    public void setUsername(String username) throws IllegalAccessException{
        if(username.length() < 15) this.username = username;  // restrição unique ???
        else throw new IllegalAccessException("Tamanho de username inválido");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws IllegalAccessException{
        if(password.length() < 32 && password != null) this.password = password;
        else throw new IllegalAccessException("Tamanho de senha inválido");
    }

    public LocalDate getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(LocalDate lastAccess) {
        this.lastAccess = lastAccess;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    //</editor-fold>

}
