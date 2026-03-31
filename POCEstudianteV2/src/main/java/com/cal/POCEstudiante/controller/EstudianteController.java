package com.cal.POCEstudiante.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/estudiantes")
public class EstudianteController {

    private static int codigo = 123;

    @RequestMapping(value = "/healthCheck")
    public String healthCheck() {
        return "Servicio Estudiante Ok!";
    }


    @GetMapping(value = "/")
    public int getCodigo() {
        return codigo;
    }

    @PostMapping(value = "/{cod}")
    public int setCodigo(@PathVariable("cod") int cod) {
        codigo = cod;
        return codigo;
    }
}
