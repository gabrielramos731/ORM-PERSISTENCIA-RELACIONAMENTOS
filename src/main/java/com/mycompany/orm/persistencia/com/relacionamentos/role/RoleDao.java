package com.mycompany.orm.persistencia.com.relacionamentos.role;

import com.mycompany.orm.persistencia.com.relacionamentos.repository.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoleDao extends Dao<Role> {
    
    public final static String TABLE = "role";

    @Override
    public String getSaveStatement() {
        return "insert into" + TABLE + "(name) values (?)";
    }

    @Override
    public String getUpdateStatement() {
        return " update " + TABLE + "set name = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "select id, name" + " from role where id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "select id, name" + " from role";
    }

    @Override
    public String getDeleteStatement() {
        return "Delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Role role) {
        try {
            pstmt.setString(1, role.getName());

            // Se for uma atualização (update), você também precisa definir o ID.
            if (role.getId() != null) {
                pstmt.setLong(2, role.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Role extractObject(ResultSet rs) {
        Role role = null;

        try {
            role = new Role();
            role.setId(rs.getLong("id"));
            role.setName(rs.getString("name"));
            
        }catch (Exception ex) {
            Logger.getLogger(RoleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }
}
