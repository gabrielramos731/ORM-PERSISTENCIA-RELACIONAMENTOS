package ifnmg.edu.br.librarian;

import ifnmg.edu.br.credential.Credential;
import ifnmg.edu.br.credential.CredentialDao;
import ifnmg.edu.br.repository.Dao;
import ifnmg.edu.br.user.UserDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class LibrarianDao extends Dao<Librarian> {
    public static final String TABLE = "librarian";

    @Override
    public String getSaveStatement() {
        return "insert into " + TABLE + "(name,email,birthdate,id) values (?,?,?,?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update " + TABLE + " set name = ?, email = ?, birthdate = ? where id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "select id, name, email, birthdate from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "select id, name, email, birthdate from " + TABLE;
    }

    @Override
    public String getDeleteStatement() {
        return "delete from " + TABLE + " where id = ?";
    }


    @Override
    public Librarian extractObject(ResultSet rs) {

        Librarian queryLibrarian = null;

        try {

            queryLibrarian = new Librarian();

            queryLibrarian.setId(rs.getLong("id"));
            Credential credential = new CredentialDao().findById(queryLibrarian.getId());
            queryLibrarian.setName(credential.getUser().getName());
            queryLibrarian.setEmail(credential.getUser().getEmail());
            queryLibrarian.setRole(credential.getUser().getRole());
            queryLibrarian.setBirthDate(credential.getUser().getBirthDate());
            queryLibrarian.setCredential(credential);
        } catch (Exception ex) {
            System.out.println("Exception in extractObject: " + ex);
        }

        return queryLibrarian;
    }
    
    @Override
    public Long saveOrUpdate(Librarian e) {
        Long idLibrarian = new UserDao().saveOrUpdate(e);
        if ( e.getId() == null || e.getId() == 0) {
            e.setId(-idLibrarian);
        } else {
            e.setId(idLibrarian);
        }

        super.saveOrUpdate(e);
        new CredentialDao().saveOrUpdate(e.getCredential());

        return idLibrarian;
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Librarian e){
        try {
            if(e.getId() != null && e.getId() < 0) {
                pstmt.setString(1, e.getName());
                pstmt.setString(2, e.getEmail());
                pstmt.setObject(3, e.getBirthDate(), Types.DATE);
                pstmt.setLong(4, -e.getId());
            } else {
                pstmt.setString(1, e.getName());
                pstmt.setString(2, e.getEmail());
                pstmt.setObject(3, e.getBirthDate(), Types.DATE);
                pstmt.setLong(4, e.getId());
            }
        } catch ( SQLException ex ) {
            System.out.println("Exception in composeSave or Update: " + ex);
        }
    }

}
