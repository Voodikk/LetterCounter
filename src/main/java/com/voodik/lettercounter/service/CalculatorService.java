package com.voodik.lettercounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculatorService {

    private final CheckSyntaxService checkSyntaxService;

    @Autowired
    CalculatorService(CheckSyntaxService checkSyntaxService) {
        this.checkSyntaxService = checkSyntaxService;
    }

    public String calculateLetterCount(String string) {

        String checkSyntax = checkSyntaxService.checkSyntax(string);

        if (checkSyntax != null) {
            return checkSyntax;
        }
        else {
            Map<Character, Integer> frequencyMap = new HashMap<>();
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (frequencyMap.containsKey(c)) {
                    frequencyMap.put(c, frequencyMap.get(c) + 1);
                } else {
                    frequencyMap.put(c, 1);
                }
            }
            return frequencyMap.entrySet().stream()
                    .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                    .map(entry -> entry.getKey() + ": " + entry.getValue())
                    .collect(Collectors.joining(", "));
        }
    }
}
