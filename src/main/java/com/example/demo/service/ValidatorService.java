package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ValidatorService {

    public List<String> validate(String name, String email, String phone) {
        List<String> errors = new ArrayList<>();

        // Ошибка 1: Ошибка граничных значений (&& вместо ||)
        if (name.length() < 2 && name.length() > 20) {
            errors.add("Имя должно быть от 2 до 20 символов.");
        }

        // Ошибка 5: Цифры в имени (логика есть, флаг забыт)
        if (name.matches(".*\\d.*")) {
            System.out.println("Имя содержит цифры");
            // Пропущено: isValid = false;
        }

        // Ошибка 4: Законы де Моргана (&& вместо || для отрицаний)
        if (!email.contains("@") && !email.contains(".")) {
            errors.add("Email должен содержать @ и .");
        }

        // Ошибка 3: Крах при пустом вводе
        // Телефон будет очищен от нецифр далее
        String phoneClean = phone.replaceAll("[^0-9]", "");
        if (phoneClean.charAt(0) == '8') { // Крашнется, если строка пустая
            phoneClean = phoneClean.replaceFirst("8", "7"); // Ошибка 2: Замена не только в начале
        }
        
        if (phoneClean.length() != 11) {
            errors.add("Телефон должен содержать 11 цифр.");
        }

        return errors;
    }

    public String formatPhone(String phone) {
        String phoneClean = phone.replaceAll("[^0-9]", "");
        if (phoneClean.startsWith("8")) phoneClean = "7" + phoneClean.substring(1);
        
        // Ошибка 6: Ошибка форматирования (потеряна скобка)
        return "+7 (" + phoneClean.substring(1, 4) + " " + phoneClean.substring(4, 7) + "-" + phoneClean.substring(7, 9) + "-" + phoneClean.substring(9, 11);
    }
}
