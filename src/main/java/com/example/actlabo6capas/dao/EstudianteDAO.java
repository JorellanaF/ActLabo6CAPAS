package com.example.actlabo6capas.dao;

import com.example.actlabo6capas.domain.Estudiante;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface EstudianteDAO {
    List<Estudiante> findAll() throws DataAccessException;
    Estudiante findOne(Integer id) throws DataAccessException;
    void insert(Estudiante estudiante) throws DataAccessException;
    void delete(Integer id) throws DataAccessException;
}
