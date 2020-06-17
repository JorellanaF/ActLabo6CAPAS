package com.example.actlabo6capas.service;

import com.example.actlabo6capas.domain.Estudiante;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface EstudianteService {

    List<Estudiante> findAll() throws DataAccessException;

    Estudiante findOne(Integer code) throws DataAccessException;

    void insert(Estudiante estudiante) throws DataAccessException;

    void delete(Integer codigoEstudiante) throws DataAccessException;
}
