//HANDLES ONLY THE HTTP REQUESTS

package com.campusCore.CampusCore.controller;



import com.campusCore.CampusCore.Service.StudentService;
import com.campusCore.CampusCore.dto.StudentRequestDTO;
import com.campusCore.CampusCore.dto.StudentResponseDTO;
import com.campusCore.CampusCore.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    //constructor

//API 1 - to get all students
    @GetMapping("/students")
    public List<StudentResponseDTO> getStudents(){
        return service.getAllStudents();
    }

//API 2 - to get student by id
    @GetMapping("/students/{studentId}")
    public StudentResponseDTO getStudent(@PathVariable int studentId){
        return service.getStudentById(studentId);
    }

//API 3 - to get the json data into object
    @PostMapping("/students")
    public StudentResponseDTO addStudent(@Valid @RequestBody StudentRequestDTO dto){
        return service.addNewStudents(dto);
    }

//API 4- to get data and update the data
    @PutMapping("/students/{studentId}")
    public StudentResponseDTO updateStudent(@PathVariable int studentId,
                                 @Valid @RequestBody StudentRequestDTO dto){
        return service.updateStudentDetails(studentId,dto);
    }

    //API 5 - to delete the entries
    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId){
        service.deleteStudentEntry(studentId);
        return "Student Deleted Successfully";
    }
}

