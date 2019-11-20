package iot.turntabl.springweb.controllers;

import iot.turntabl.springweb.models.Number;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathsController {

    @RequestMapping("/add")
    public Number add(int num1, int num2){
        return new Number();
    }

    @RequestMapping("/subtract")
    public Number subtract(int num1, int num2){
        return new Number();
    }
}
