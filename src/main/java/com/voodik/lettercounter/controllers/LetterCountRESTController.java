package com.voodik.lettercounter.controllers;

import com.voodik.lettercounter.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main/result")
public class LetterCountRESTController {

    @Autowired
    CalculatorService calculatorService;

    @PostMapping
    public String getResult(@RequestParam("string") String string) {
        return calculatorService.calculateLetterCount(string);
    }
}
