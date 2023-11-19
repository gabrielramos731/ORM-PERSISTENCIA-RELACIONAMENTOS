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
            Role role = new Role("Bibliotecario");
            Long roleID = new RoleDao().saveOrUpdate(role);
            role.setId(roleID);

            Librarian anazaira = null;
            anazaira = new Librarian(
                    "Ana Zaira",
                    "anazaira@mail.com",
                    LocalDate.now(),
                    role,
                    new Credential(null, "anazaira", "1234", LocalDate.now(), true, null));
            
            anazaira.getCredential().setUser(anazaira);
            Long userId = new LibrarianDao().saveOrUpdate(anazaira);

            System.out.println(anazaira.toString());

            Librarian anazairaatt = null;
            anazairaatt = new LibrarianDao().findById(userId);
            anazairaatt.setEmail("anazaira@maiaiidsoifdhsifal.com");
            anazairaatt.setBirthDate(LocalDate.of(2001, 1,15));
            new LibrarianDao().saveOrUpdate(anazairaatt);

            System.out.println("Bibliotecário criado com sucesso");
            System.out.println(anazairaatt.toString());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void TesteB() {
        try {
            Role role = new Role("Leitor");
            Long roleID = new RoleDao().saveOrUpdate(role);
            role.setId(roleID);

            Reader beatrizyana = null;
            beatrizyana = new Reader(
                    "Beatriz Yana",
                    "beatrizyana@mail.com",
                    LocalDate.now(),
                    role,
                    new Credential(null, "beatrizyana", "4321", LocalDate.now(), true, beatrizyana));
            beatrizyana.getCredential().setUser(beatrizyana);
            Long userId = new ReaderDao().saveOrUpdate(beatrizyana);

            System.out.println(beatrizyana.toString());

            Reader beatrizyanaatt = new ReaderDao().findById(userId);
            beatrizyanaatt.setEmail("beatrizyana@gmail.com");
            beatrizyanaatt.setBirthDate(LocalDate.of(2003, 5,23));
            new ReaderDao().saveOrUpdate(beatrizyanaatt);

            System.out.println("Leitor criado com sucesso");
            System.out.println(beatrizyanaatt.toString());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void TesteC() {
        try {
            Role role = new Role("Leitor");
            Long roleID = new RoleDao().saveOrUpdate(role);
            role.setId(roleID);

            Reader xeciliaxerxes = null;
            xeciliaxerxes = new Reader(
                    "Xecilia Xerxes",
                    "xeciliaxerxes@hotmail.com",
                    LocalDate.now(),
                    role,
                    new Credential(null, "xeciliaxerxes", "abc123", LocalDate.now(), true, xeciliaxerxes));
            xeciliaxerxes.getCredential().setUser(xeciliaxerxes);
            Long userId = new ReaderDao().saveOrUpdate(xeciliaxerxes);

            System.out.println(xeciliaxerxes.toString());

            Reader xeciliaxerxesatt = new ReaderDao().findById(userId);
            xeciliaxerxesatt.setEmail("xexiliaxerxes@outlook.com");
            xeciliaxerxesatt.setBirthDate(LocalDate.of(1500, 2, 22));
            new ReaderDao().saveOrUpdate(xeciliaxerxesatt);

            System.out.println("Leitor 2 criado com sucesso");
            System.out.println(xeciliaxerxesatt.toString());

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
                System.out.println(x.getName());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void TesteF() {
        try {
            Credential anazaira = new Credential();
            anazaira.setUsername("anazaira");
            anazaira.setPassword("1234");

            User user = new CredentialDao().authenticate(anazaira);
            user.setCredential(new CredentialDao().findById(user.getId()));
            System.out.println(user.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
