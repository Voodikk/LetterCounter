package com.voodik.lettercounter.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CalculatorServiceTest {
    CheckSyntaxService syntaxService = new CheckSyntaxService();

    CalculatorService calculatorService = new CalculatorService(syntaxService);

    @Test
    void calculateWithValidString() {
        String test1 = calculatorService.calculateLetterCount("aaaccclllll");
        Assertions.assertEquals("l: 5, a: 3, c: 3", test1);

        String test2 = calculatorService.calculateLetterCount("ang");
        Assertions.assertEquals("a: 1, g: 1, n: 1", test2);

        String test3 = calculatorService.calculateLetterCount("aapppbv");
        Assertions.assertEquals("p: 3, a: 2, b: 1, v: 1", test3);
    }

    @Test
    void calculateWithInvalidString() {
        String test1 = calculatorService.calculateLetterCount("");
        Assertions.assertEquals("Ошибка: Слишком короткая строка", test1);

        String test2 = calculatorService.calculateLetterCount("15");
        Assertions.assertEquals("Ошибка: Строка должна состоять только из символов английского алфавита в нижнем регистре", test2);

        String test3 = calculatorService.calculateLetterCount("aaaamvbobf1");
        Assertions.assertEquals("Ошибка: Строка должна состоять только из символов английского алфавита в нижнем регистре", test3);
    }
}
