package com.example.actlabo6capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import com.example.actlabo6capas.dao.EstudianteDAO;
import com.example.actlabo6capas.domain.Estudiante;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EstudianteDAO estudianteDAO;

    @RequestMapping("/agregar")
    private ModelAndView agregarForm(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("estudiante", new Estudiante());
        mav.setViewName("agregarEstudiante");

        return mav;
    }

    @RequestMapping("/eliminar")
    private ModelAndView eliminarForm(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("estudiante", new Estudiante());
        mav.setViewName("eliminarEstudiante");

        return mav;
    }

    @RequestMapping("/eliminarE")
    private ModelAndView eliminar(@RequestParam("codigoEstudiante") int id){
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;

        try {
            estudianteDAO.delete(id);
        }catch(Exception e) {
            e.printStackTrace();
        }
        mav.addObject("estudiante", new Estudiante());
        mav.setViewName("eliminarEstudiante");

        return mav;

    }


    @RequestMapping("/inicio")
    public ModelAndView inicio() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");

        return mav;
    }

    @RequestMapping("/validar")
    private ModelAndView validarForm(@Valid @ModelAttribute Estudiante estudiante, BindingResult result){
        ModelAndView mav = new ModelAndView();

        if (result.hasErrors()){
            mav.setViewName("agregarEstudiante");
        }else {
            estudianteDAO.insert(estudiante);
            mav.addObject("estudiante", new Estudiante());
            mav.setViewName("agregarEstudiante");
        }

        return mav;
    }

    //Mostrar lista de Estudiante
    @RequestMapping("/listado")
    public ModelAndView listado() {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try {
            estudiantes = estudianteDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("listado");

        return mav;
    }

}
