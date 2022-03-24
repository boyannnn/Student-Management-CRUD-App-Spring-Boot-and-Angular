package boyan.springbootstudentcrud.repository;

import boyan.springbootstudentcrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
