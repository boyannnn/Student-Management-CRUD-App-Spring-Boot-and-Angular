package boyan.springbootstudentcrud.controller;

import boyan.springbootstudentcrud.exception.ResourceNotFoundException;
import boyan.springbootstudentcrud.model.Student;
import boyan.springbootstudentcrud.repository.StudentRepository;
import boyan.springbootstudentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent (@PathVariable Long id, @RequestBody Student studentInfo) {

        return studentService.updateStudent(id, studentInfo);
    }

    // todo: validate
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id){

        return studentService.deleteStudent(id);

    }

}
