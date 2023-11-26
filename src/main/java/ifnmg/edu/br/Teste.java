package ifnmg.edu.br;

import java.time.LocalDate;

import ifnmg.edu.br.credential.Credential;
import ifnmg.edu.br.credential.CredentialDao;
import ifnmg.edu.br.librarian.Librarian;
import ifnmg.edu.br.librarian.LibrarianDao;
import ifnmg.edu.br.reader.Reader;
import ifnmg.edu.br.reader.ReaderDao;
import ifnmg.edu.br.role.Role;
import ifnmg.edu.br.role.RoleDao;
import ifnmg.edu.br.user.User;
import java.util.List;

public class Teste {
    public static void TesteA() {
        try {
            Role role = new Role("ADMINISTRADOR");
            Long roleID = new RoleDao().saveOrUpdate(role);
            role.setId(roleID);

            Librarian admin = null;
            admin = new Librarian(
                    "admin",
                    "admin@mail.com",
                    LocalDate.now(),
                    role,
                    new Credential(null, "admin", "123", LocalDate.now(), true, null));
            
            admin.getCredential().setUser(admin);
            Long userId = new LibrarianDao().saveOrUpdate(admin);

            System.out.println("Administrador criado com sucesso");
            System.out.println(admin.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void TesteB() {
        try {
            Role role = new Role("BIBLIOTECARIO");
            Long roleID = new RoleDao().saveOrUpdate(role);
            role.setId(roleID);

            Librarian biblio1 = null;
            biblio1 = new Librarian(
                    "biblio1",
                    "biblio1@mail.com",
                    LocalDate.now(),
                    role,
                    new Credential(null, "biblio1", "asdf", LocalDate.now(), true, biblio1));
            biblio1.getCredential().setUser(biblio1);
            Long userId = new LibrarianDao().saveOrUpdate(biblio1);

            System.out.println("Bibliotecario criado com sucesso");
            System.out.println(biblio1.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void TesteC() {
        try {
            Role role = new Role("LEITOR");
            Long roleID = new RoleDao().saveOrUpdate(role);
            role.setId(roleID);

            Reader leitor1 = null;
            leitor1 = new Reader(
                    "leitor1",
                    "leitor1@hotmail.com",
                    LocalDate.now(),
                    role,
                    new Credential(null, "leitor1", "qwerty", LocalDate.now(), true, leitor1));
            
            leitor1.getCredential().setUser(leitor1);
            Long userId = new ReaderDao().saveOrUpdate(leitor1);
            
            System.out.println("Leitor criado com sucesso");
            System.out.println(leitor1.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void TesteD() {
        List<Librarian> allObjects = null;

        try {
            allObjects = new LibrarianDao().findAll();
            System.out.println("Todos os bibliotecários: ");
            for (var x : allObjects) {
                System.out.println(x.getName());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void TesteE() {
        List<Reader> allObjects = null;

        try {
            allObjects = new ReaderDao().findAll();
            System.out.println("Todos os leitores: ");
            for (var x : allObjects) {
                System.out.println(x.getRole().getName());
                System.out.println(x.getName());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
