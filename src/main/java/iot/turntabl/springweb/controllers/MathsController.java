package iot.turntabl.springweb.controllers;

import iot.turntabl.springweb.models.Number;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathsController {
    @Autowired
    private Maths ops;

    @RequestMapping("/add")
    public Number add(
            @RequestParam(value = "num1") String num1,
            @RequestParam(value = "num2") String num2){
        Integer number1 = Integer.parseInt(num1);
        Integer number2 = Integer.parseInt(num2);
        return new Number(this.ops.add(number1, number2));
    }

    @RequestMapping("/subtract")
    public Number subtract(
            @RequestParam(value = "num1") String num1,
            @RequestParam(value = "num2") String num2){
        Integer number1 = Integer.parseInt(num1);
        Integer number2 = Integer.parseInt(num2);
        return new Number(this.ops.subtract(number1 , number2));
    }
}
