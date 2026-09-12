package com.cidoliveira.api_cadastro.Persons;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PersonController {

    @GetMapping("/hello")
    public String olaMundo() {
        return "Olá, mundo!";
    }

}
