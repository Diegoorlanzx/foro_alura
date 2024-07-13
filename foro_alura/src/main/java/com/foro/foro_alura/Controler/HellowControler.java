package com.foro.foro_alura.Controler;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HellowControler {

    @GetMapping
    public String Hellow (){
        return "hola mundo xdxd";
    }
}

