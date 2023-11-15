package com.mycompany.orm.persistencia.com.relacionamentos.credential;

import com.mycompany.orm.persistencia.com.relacionamentos.repository.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CredentialDao extends Dao<Credential> {
    
    public final static String TABLE = "credential";

    @Override
    public String getSaveStatement() {
        return "insert into " + TABLE + "(username, password, lastAcess, enabled, userId) values(?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
         return " update "+ TABLE + "set username = ?, password= ?, lastAccess= ?, enabled = ?, userId = ? where id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "select id, username, password, lastAccess, enabled, userId" + " from credential where id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "select id, username, password, lastAccess, enabled, userId" + " from credential";
    }

    @Override
    public String getDeleteStatement() {
        return "Delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Credential credential) {
        try {
            pstmt.setString(1, credential.getUsername());
            pstmt.setString(2, credential.getPassword());
            pstmt.setObject(3, credential.getLastAccess());
            pstmt.setBoolean(4, credential.isEnabled());
            pstmt.setLong(5, credential.getUserId());

            // Se for uma atualização (update), você também precisa definir o ID.
            if (credential.getId() != null) {
                pstmt.setLong(6, credential.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CredentialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Credential extractObject(ResultSet rs) {
         Credential credential = null;

        try {
            credential = new Credential();
            credential.setId(rs.getLong("id"));
            credential.setUsername(rs.getString("username"));
            credential.setPassword(rs.getString("password"));
            credential.setLastAccess(rs.getObject("lastAccess", LocalDate.class));
            credential.setEnabled(rs.getBoolean("enabled"));
            credential.setUserId(rs.getLong("userId"));
        }catch (Exception ex) {
            Logger.getLogger(CredentialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return credential;
    }
}
