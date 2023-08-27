package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;
import java.util.Collection;

@RestController
@RequestMapping("/Student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student newStudent){
        studentService.createStudent(newStudent);
        return studentService.createStudent(newStudent);
    }
    @GetMapping
    public ResponseEntity<Student> getStudent(@RequestBody Long getStudentNumber){
        Student student = studentService.getStudent(getStudentNumber);
        if (student ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @PutMapping
    public ResponseEntity<Student> putStudent(@RequestBody Student putStudent){
        Student student = studentService.editStudent(putStudent);
        if (student==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(student);
    }
    @DeleteMapping
    public ResponseEntity<Student> removeStudent(@RequestBody Long removeStudentNumber){
        studentService.removeStudent(removeStudentNumber);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/all")
    public ResponseEntity<Collection<Student>> getStudent(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
