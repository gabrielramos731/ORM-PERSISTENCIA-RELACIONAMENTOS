package ifnmg.edu.br.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public abstract interface IDao <E>{
    String getSaveStatement();
    String getUpdateStatement();
    String getFindByIdStatement();
    String getFindAllStatement();
    String getDeleteStatement();
    void composeSaveOrUpdateStatement(PreparedStatement pstmt, E e);
    E extractObject(ResultSet rs);
    ArrayList<E> extractObjects(ResultSet rs);
    Long saveOrUpdate(E e);
    E findById(Long id);
    ArrayList<E> findAll();
    void delete(Long id);

}
