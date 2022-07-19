package boyan.springbootstudentcrud.service;

import boyan.springbootstudentcrud.exception.ResourceNotFoundException;
import boyan.springbootstudentcrud.model.Student;
import boyan.springbootstudentcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return this.studentRepository.findAll();
    }

    public ResponseEntity<Student> getStudentById(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id '"+id+"' does not exist"));
        return ResponseEntity.ok(student);
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public ResponseEntity<Student> updateStudent (Long id, Student studentInfo) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id '" + id + "' does not exist"));

        student.setFirstName(studentInfo.getFirstName());
        student.setLastName(studentInfo.getLastName());
        student.setGrade(studentInfo.getGrade());

        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    // todo: validate
    public ResponseEntity<Map<String, Boolean>> deleteStudent(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id '" + id + "' does not exist"));

        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
