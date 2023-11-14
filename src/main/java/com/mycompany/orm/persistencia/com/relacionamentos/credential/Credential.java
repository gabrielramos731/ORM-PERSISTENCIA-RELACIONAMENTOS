package com.mycompany.orm.persistencia.com.relacionamentos.credential;

import java.time.LocalDate;

/**
 *
 * @author ramos
 */
public class Credential {
    
    private String username;
    private String password;
    private LocalDate lastAcess;
    private boolean enabled;

    public Credential(String username, String password, LocalDate lastAcess, boolean enabled) throws Exception{
        setUsername(username);
        setPassword(password);
        this.lastAcess = lastAcess;
        this.enabled = enabled;
    }

    //<editor-fold defaultstate="collapsed" desc="constructors">
    
    public Credential() {}

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

    public LocalDate getLastAcess() {
        return lastAcess;
    }

    public void setLastAcess(LocalDate lastAcess) {
        this.lastAcess = lastAcess;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    //</editor-fold>
}
