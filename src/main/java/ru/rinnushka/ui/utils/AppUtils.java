package ru.rinnushka.ui.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class AppUtils {

    @Value("${app.baseUrl}")
    private String baseUrl;

    public Model addBaseUrlToModel(Model model) {
        model.addAttribute("baseUrl", baseUrl);
        return model;
    }
}
