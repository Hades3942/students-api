package tz.ac.suza.wt.students_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tz.ac.suza.wt.students_api.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByCourse(String course);

    Optional<Student> findByEmail(String email);

    boolean existsByEmail(String email);
}

