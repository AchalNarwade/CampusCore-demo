//HANDLES ALL THE BUSINESS LOGIC

package com.campusCore.CampusCore.Service;

import com.campusCore.CampusCore.Repository.StudentRepository;
import com.campusCore.CampusCore.dto.StudentRequestDTO;
import com.campusCore.CampusCore.dto.StudentResponseDTO;
import com.campusCore.CampusCore.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;


    //GET ALL STUDENTS-GET
    public List<StudentResponseDTO> getAllStudents(){
        List<Student> students = repo.findAll();
        List<StudentResponseDTO> reponseList = new ArrayList<>();

        for(Student student: students){
            StudentResponseDTO dto = new StudentResponseDTO();
            dto.setId(student.getId());
            dto.setName(student.getName());
            dto.setEmail(student.getEmail());

            reponseList.add(dto);

        }
        return reponseList;
    }

    //GET STUDENTS BY ID
    public StudentResponseDTO getStudentById(int studentId){
        Student student = repo.findById(studentId).orElse(new Student());
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setEmail(student.getEmail());
        dto.setName(student.getName());
        dto.setId(student.getId());

        return dto;
    }

    //TO ADD THE STUDENT IN THE LIST-POST
    public StudentResponseDTO addNewStudents(StudentRequestDTO dto){
//        students.add(student);
//        return student;

//        return repo.save(students);
        Student student = new Student();

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setPassword(dto.getPassword());

        Student savedStudent = repo.save(student);

        StudentResponseDTO response = new StudentResponseDTO();

        response.setId(savedStudent.getId());
        response.setName(savedStudent.getName());
        response.setEmail(savedStudent.getEmail());

        return response;
    }


    //TO UPDATE THE STUDENT DATA-PUT
    public StudentResponseDTO updateStudentDetails(int studentId, StudentRequestDTO dto){
        Student existingStudent = repo.findById(studentId).orElse(null);
        if(existingStudent !=null){
            existingStudent.setName(dto.getName());
            existingStudent.setEmail(dto.getEmail());
            existingStudent.setPassword(dto.getPassword());

            Student updatedStudent = repo.save(existingStudent);
            StudentResponseDTO response = new StudentResponseDTO();

            response.setName(updatedStudent.getName());
            response.setEmail(updatedStudent.getEmail());
            response.setId(updatedStudent.getId());

            return response;
        }
        return null;
    }

    //TO DELETE THE STUDENT ENTRY-DELETE
    public void deleteStudentEntry( int studentId){
//        for(int i=0;i<students.size();i++){
//            if(students.get(i).getId() == studentId){
//                students.remove(i);
//
//                return "Student Deleted";
//            }
//        }
//        return "Student Not found";

        repo.deleteById(studentId);
    }

}
