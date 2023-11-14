package com.mycompany.orm.persistencia.com.relacionamentos.role;

import com.mycompany.orm.persistencia.com.relacionamentos.repository.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoleDao extends Dao<Role> {
    
    public final static String TABLE = "role";

    @Override
    public String getSaveStatement() {
        return null;
    }

    @Override
    public String getUpdateStatement() {
        return null;
    }

    @Override
    public String getFindByIdStatement() {
        return null;
    }

    @Override
    public String getFindAllStatement() {
        return null;
    }

    @Override
    public String getDeleteStatement() {
        return null;
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Role role) {

    }

    @Override
    public Role extractObject(ResultSet rs) {
        return null;
    }
}
