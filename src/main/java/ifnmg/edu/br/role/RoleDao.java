package ifnmg.edu.br.role;

import ifnmg.edu.br.repository.Dao;
import ifnmg.edu.br.repository.DbConnection;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class RoleDao extends Dao<Role> {
    public static final String TABLE = "role";

    @Override
    public String getSaveStatement() {
        return "insert into " + TABLE + " (name) values (?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update " + TABLE + " set name = ? where id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "select name, id from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "select name, id from " + TABLE;
    }

    @Override
    public String getDeleteStatement() {
        return "delete from " + TABLE + " where id = ?";
    }

    private String getFindByRoleStatement(){
        return "select name, id from " + TABLE + " where name = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Role e) {
        try {
            pstmt.setObject(1, e.getName(), Types.VARCHAR);

            if (e.getId() != null) {
                pstmt.setObject(2, e.getId(), Types.BIGINT);
            }
        } catch (SQLException ex) {
            System.out.println("Exception in composeSave or Update: " + ex);
        }
    }

    public Role findByRole(String role) {
        try ( PreparedStatement preparedStatement
                      = DbConnection.getConnection().prepareStatement(
                getFindByRoleStatement())) {

            // Assemble the SQL statement with the id
            preparedStatement.setString(1, role);

            // Show the full sentence
            // System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next()) {
                return extractObject(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception im findByRole: " + ex);
        }

        return null;
    }

    @Override
    public Long saveOrUpdate(Role role) {
        Long id = 0L;
        Role roleToCompare = new RoleDao().findByRole(role.getName());
        if(roleToCompare != null)
            return roleToCompare.getId();

        if (role.getId() == null
                || role.getId() == 0) {

            // Insert a new register
            // try-with-resources
            try (PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(
                    getSaveStatement(),
                    Statement.RETURN_GENERATED_KEYS)) {

                // Assemble the SQL statement with the data (->?)
                composeSaveOrUpdateStatement(preparedStatement, role);

                // Show the full sentence
                // System.out.println(">> SQL: " + preparedStatement);

                // Performs insertion into the database
                preparedStatement.executeUpdate();

                // Retrieve the generated primary key
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                // Moves to first retrieved data
                if (resultSet.next()) {

                    // Retrieve the returned primary key
                    id = resultSet.getLong(1);
                }

            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }

        } else {
            // Update existing record
            try (PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(
                    getUpdateStatement())) {

                // Assemble the SQL statement with the data (->?)
                composeSaveOrUpdateStatement(preparedStatement, role);

                // Show the full sentence
                // System.out.println(">> SQL: " + preparedStatement);

                // Performs the update on the database
                preparedStatement.executeUpdate();

                // Keep the primary key
                id = (role.getId());

            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }

        return id;
    }

    @Override
    public Role extractObject(ResultSet rs) {

        Role queryRole = null;

        try {
            queryRole = new Role();

            queryRole.setId(rs.getLong("id"));
            queryRole.setName(rs.getString("name"));
        } catch (Exception ex) {
            System.out.println("Exception in extractObject: " + ex);
        }

        return queryRole;
    }

}
