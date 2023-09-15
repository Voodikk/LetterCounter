package com.voodik.lettercounter.service;

import org.springframework.stereotype.Service;

@Service
public class CheckSyntaxService {

    public String checkSyntax(String string) {
        if (string.length() < 1) {
            return "Ошибка: Слишком короткая строка";
        }
        else if (!string.matches("[a-z]+")) {
            return "Ошибка: Строка должна состоять только из символов английского алфавита в нижнем регистре";
        }
        else {
            return null;
        }
    }
}
