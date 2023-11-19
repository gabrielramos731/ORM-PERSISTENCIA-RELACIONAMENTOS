package ifnmg.edu.br.librarian;

import java.time.LocalDate;

import ifnmg.edu.br.credential.Credential;
import ifnmg.edu.br.role.Role;
import ifnmg.edu.br.user.User;

public class Librarian extends User{

    public Librarian(){
        super();
    }

    public Librarian(String name, String email, LocalDate birthDate, Role role, Credential credential) throws Exception{
        super(name, email, birthDate, role, credential);
    }

}

