package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController { //Api Layer

    private final StudentService studentService; // This is a dependency

    @Autowired //Auto wire the dependency
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){ //Send data to server
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}") //DELETE
    public void deleteStudent(@PathVariable("studentId") Long studentID){
        studentService.deleteStudent(studentID); //Generate Request with Delete + StudentID in PathName
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }
}
