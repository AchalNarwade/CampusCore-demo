package com.campusCore.CampusCore.controller;

import com.campusCore.CampusCore.Service.StudentService;
import com.campusCore.CampusCore.dto.StudentResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private final StudentService service;

    public HomeController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<StudentResponseDTO> home(){
        return service.getAllStudents();
    }
}
