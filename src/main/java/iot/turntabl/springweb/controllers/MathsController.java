package iot.turntabl.springweb.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import iot.turntabl.springweb.models.Number;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class MathsController {
    @Autowired
    private Maths ops;

    @ApiOperation("Adds two numbers passed as route parameters and returns the result")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Number add(
            @RequestParam(value = "num1") String num1,
            @RequestParam(value = "num2") String num2){
        Integer number1 = Integer.parseInt(num1);
        Integer number2 = Integer.parseInt(num2);
        return new Number(this.ops.add(number1, number2));
    }

    @ApiOperation("Subtracts two numbers passed as parameters to route and returns the result")
    @RequestMapping(value = "/subtract", method = RequestMethod.GET)
    public Number subtract(
            @RequestParam(value = "num1") String num1,
            @RequestParam(value = "num2") String num2){
        Integer number1 = Integer.parseInt(num1);
        Integer number2 = Integer.parseInt(num2);
        return new Number(this.ops.subtract(number1 , number2));
    }
}
