package ifnmg.edu.br.user;

import ifnmg.edu.br.repository.Dao;
import ifnmg.edu.br.role.Role;
import ifnmg.edu.br.role.RoleDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class UserDao extends Dao<User> {

    public static final String TABLE = "user";

    @Override
    public String getSaveStatement() {
        return "insert into " + TABLE + " (name, email, birthdate, role_id) values(?,?,?,?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update " + TABLE + " set name = ?, email = ?, birthdate = ?, role_id = ? where id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "select name, email, birthdate, id, role_id from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "select * from " + TABLE;
    }

    @Override
    public String getDeleteStatement() {
        return "delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, User user) {
        try {
            if (user.getName() != null)
                pstmt.setObject(1, user.getName(), Types.VARCHAR);
            if (user.getEmail() != null)
                pstmt.setObject(2, user.getEmail(), Types.VARCHAR);
            if (user.getBirthDate() != null)
                pstmt.setObject(3, user.getBirthDate(), Types.DATE);
            if (user.getRole().getId() != null)
                pstmt.setObject(4, user.getRole().getId(), Types.BIGINT);
            if (user.getId() != null)
                pstmt.setObject(5, user.getId(), Types.BIGINT);
        } catch (Exception ex) {
            System.out.println("Exception in ComposeSave or Update " + ex);
        }
    }

    @Override
    public User extractObject(ResultSet rs) {
        User user = null;
        try {
            user = new User();
            user.setName(rs.getString("name"));
            user.setId(rs.getLong("id"));
            Role role = new RoleDao().findById(rs.getLong("role_id"));
            user.setRole(role);
            user.setEmail(rs.getString("email"));
            user.setBirthDate(rs.getDate("birthdate").toLocalDate());
        } catch (Exception ex) {
            System.out.println("Exception in extractObject: " + ex);
        }
        return user;
    }
}
