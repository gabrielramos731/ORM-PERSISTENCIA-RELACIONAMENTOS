package com.mycompany.orm.persistencia.com.relacionamentos.reader;

import com.mycompany.orm.persistencia.com.relacionamentos.repository.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReaderDao extends Dao<Reader> {
    
    public final static String TABLE = "reader";

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
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Reader reader) {

    }

    @Override
    public Reader extractObject(ResultSet rs) {
        return null;
    }
}
