package ifnmg.edu.br.reader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import ifnmg.edu.br.credential.Credential;
import ifnmg.edu.br.credential.CredentialDao;
import ifnmg.edu.br.repository.Dao;
import ifnmg.edu.br.user.UserDao;

public class ReaderDao extends Dao<Reader>{
    public static final String TABLE = "reader";

    @Override
    public String getSaveStatement() {
        return "insert into " + TABLE + " (name,email,birthdate, id) values (?,?,?,?)";
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
    public Reader extractObject(ResultSet rs) {

        Reader queryReader = null;

        try {
            queryReader = new Reader();

            queryReader.setId(rs.getLong("id"));
            Credential credential = new CredentialDao().findById(queryReader.getId());
            queryReader.setName(credential.getUser().getName());
            queryReader.setEmail(credential.getUser().getEmail());
            queryReader.setRole(credential.getUser().getRole());
            queryReader.setBirthDate(credential.getUser().getBirthDate());
            queryReader.setCredential(credential);
        } catch (Exception ex) {
            System.out.println("Exception in extractObject: " + ex);
        }

        return queryReader;
    }
    
    @Override
    public Long saveOrUpdate(Reader e) {
        Long idReader = new UserDao().saveOrUpdate(e);
        if ( e.getId() == null || e.getId() == 0) {
            e.setId(-idReader);
        } else {
            e.setId(idReader);
        }

        super.saveOrUpdate(e);
        new CredentialDao().saveOrUpdate(e.getCredential());

        return idReader;
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Reader e){
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
