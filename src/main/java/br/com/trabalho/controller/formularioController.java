
package br.com.trabalho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class formularioController {
    
    @GetMapping("/exibirForm")
    public String exibirForm(){
        return "formulario";
    }
}
