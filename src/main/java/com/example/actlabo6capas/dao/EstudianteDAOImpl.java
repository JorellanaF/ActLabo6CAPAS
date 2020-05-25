package com.example.actlabo6capas.dao;

import com.example.actlabo6capas.domain.Estudiante;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class EstudianteDAOImpl implements EstudianteDAO{

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public List<Estudiante> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM public.estudiante");
        Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
        List<Estudiante> resultset = query.getResultList();

        return resultset;
    }

    @Override
    public Estudiante findOne(Integer id) throws DataAccessException {
        return null;
    }

    @Override
    @Transactional
    public void insert(Estudiante estudiante) throws DataAccessException {
        entityManager.persist(estudiante);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws DataAccessException {
        Estudiante estudiante = entityManager.find(Estudiante.class, id);
        entityManager.remove(estudiante);
    }
}
