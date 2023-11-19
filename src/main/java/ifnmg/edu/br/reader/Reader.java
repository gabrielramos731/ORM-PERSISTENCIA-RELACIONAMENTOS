package ifnmg.edu.br.reader;

import java.time.LocalDate;

import ifnmg.edu.br.credential.Credential;
import ifnmg.edu.br.role.Role;
import ifnmg.edu.br.user.User;

public class Reader extends User{
    public Reader(){
        super();
    }

    public Reader(String name, String email, LocalDate birthDate, Role role, Credential credential) throws Exception{
        super(name, email, birthDate, role, credential);
    }
}
