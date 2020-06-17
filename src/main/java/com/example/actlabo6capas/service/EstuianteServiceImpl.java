package com.example.actlabo6capas.service;

import com.example.actlabo6capas.domain.Estudiante;
import com.example.actlabo6capas.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstuianteServiceImpl implements EstudianteService{

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> findAll() throws DataAccessException {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante findOne(Integer code) throws DataAccessException {
        return estudianteRepository.getOne(code);
    }

    @Override
    public void insert(Estudiante estudiante) throws DataAccessException {
        estudianteRepository.save(estudiante);
    }

    @Override
    public void delete(Integer codigoEstudiante) throws DataAccessException {
        estudianteRepository.deleteById(codigoEstudiante);
    }
}
