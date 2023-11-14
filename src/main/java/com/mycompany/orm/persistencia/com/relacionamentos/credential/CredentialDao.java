package com.mycompany.orm.persistencia.com.relacionamentos.credential;

import com.mycompany.orm.persistencia.com.relacionamentos.repository.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CredentialDao extends Dao<Credential> {
    
    public final static String TABLE = "credential";

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
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Credential credential) {

    }

    @Override
    public Credential extractObject(ResultSet rs) {
        return null;
    }
}
