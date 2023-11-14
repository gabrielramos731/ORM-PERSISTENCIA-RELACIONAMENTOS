package com.mycompany.orm.persistencia.com.relacionamentos.librarian;

import com.mycompany.orm.persistencia.com.relacionamentos.repository.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LibrarianDao extends Dao<Librarian> {
    
    public final static String TABLE = "librarian";

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
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Librarian librarian) {

    }

    @Override
    public Librarian extractObject(ResultSet rs) {
        return null;
    }
}
