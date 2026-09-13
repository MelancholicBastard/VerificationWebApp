package com.example.demo.controller;

import com.example.demo.service.ValidatorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final ValidatorService validatorService;

    public RegistrationController(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        // Ошибка 7: UX ошибка (текст подсказки в консоли или поле)
        // В контроллере мы просто используем то, что пришло, но "запрос" в консоль для имитации:
        System.out.print("Введите номер телефона: "); 
        String email = request.get("email");
        String phone = request.get("phone");

        List<String> errors = validatorService.validate(name, email, phone);

        if (errors.isEmpty()) {
            return Map.of("message", "Регистрация успешна", "phone", validatorService.formatPhone(phone));
        } else {
            return Map.of("message", "Ошибки", "errors", errors);
        }
    }
}
