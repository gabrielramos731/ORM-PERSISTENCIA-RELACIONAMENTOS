package ifnmg.edu.br.credential;

import ifnmg.edu.br.entity.Entity;
import ifnmg.edu.br.user.User;

import java.time.LocalDate;

public class Credential extends Entity {
    private String username;
    private String password;
    private LocalDate lastAccess;
    private Boolean enabled;
    private User user;

    public Credential() {
        setEnabled(null);
    }

    public Credential(Long id, String username, String password, LocalDate lastAccess, Boolean enabled, User user) throws Exception {
        setId(id);
        setUsername(username);
        setPassword(password);
        setLastAccess(lastAccess);
        setEnabled(enabled);
        setUser(user);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws Exception {
        if (username.length() > 15 || username.equals("")) {
            throw new Exception("Tamanho invalido!");
        } else this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        this.password = password;
    }

    public LocalDate getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(LocalDate lastAccess) {
        this.lastAccess = lastAccess;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        if (enabled == null) {
            this.enabled = true;
        }
        this.enabled = enabled;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Credential encontrada: {" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastAccess=" + lastAccess +
                ", enabled=" + enabled +
                ", user=" + user +
                '}';
    }
}
