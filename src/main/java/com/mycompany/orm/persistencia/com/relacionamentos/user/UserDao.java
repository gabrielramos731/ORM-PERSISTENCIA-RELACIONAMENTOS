package com.mycompany.orm.persistencia.com.relacionamentos.user;


import com.mycompany.orm.persistencia.com.relacionamentos.repository.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao extends Dao<User> {
    
    public final static String TABLE = "user";

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
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, User user) {

    }

    @Override
    public User extractObject(ResultSet rs) {
        return null;
    }
}
