package ifnmg.edu.br.user;

import ifnmg.edu.br.credential.Credential;
import ifnmg.edu.br.entity.Entity;
import ifnmg.edu.br.role.Role;

import java.time.LocalDate;

public class User extends Entity {
    private String name;
    private String email;
    private LocalDate birthDate;
    private Role role;
    private Credential credential;


    public User() {
    }

    public User(String name, String email, LocalDate birthDate, Role role, Credential credential) throws Exception {
        setName(name);
        setEmail(email);
        setBirthDate(birthDate);
        setRole(role);
        setCredential(credential);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() > 150)
            throw new Exception("Name has more than 150 caracteres!");
        else if (name.equals(""))
            throw new Exception("Name is null!");
        else
            this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (email.length() > 255)
            throw new Exception("Email has more than 255 caracters!");
        else if (email.equals(""))
            throw new Exception("Email is null!");
        else
            this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) throws Exception {
        if (birthDate == null)
            throw new Exception("Wrong birthDate!");
        else
            this.birthDate = birthDate;
    }


    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public Credential getCredential() {
        return this.credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    @Override
    public String toString() {
        return "Nome: \"" + this.name + "\", Email: \"" + this.email + "\", Data de nascimento: \"" + this.birthDate.toString() + "\", Papel: \"" + this.role.getName()
                + "\", Credencial: \"" + this.credential.getUsername() + "\"";
    }
}
    

