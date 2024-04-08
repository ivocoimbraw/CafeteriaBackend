package com.si.apirest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holamundo")
public class HolaMundo {
    
    @GetMapping
    public String holaMundo() {
        return "Hola mundo";
    }

}
