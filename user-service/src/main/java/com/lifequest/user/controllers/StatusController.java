package com.lifequest.user.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final Environment environment;

    @Value("${spring.application.version}")
    private String appVersion;

    public StatusController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping
    public Map<String, Object> getStatus() {
        
        return Map.of(
            "appVersion", appVersion,
            "activeProfiles", List.of(environment.getActiveProfiles())
        );
    }
    @GetMapping("/docker")
    public String getStatusDocker() {
        return "Service is running on docker";
    }
}
