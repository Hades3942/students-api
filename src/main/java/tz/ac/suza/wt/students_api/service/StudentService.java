package tz.ac.suza.wt.students_api.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tz.ac.suza.wt.students_api.dto.StudentCreateDto;
import tz.ac.suza.wt.students_api.dto.StudentResponseDto;
import tz.ac.suza.wt.students_api.dto.StudentUpdateDto;
import tz.ac.suza.wt.students_api.entity.Student;
import tz.ac.suza.wt.students_api.exception.EmailAlreadyUsedException;
import tz.ac.suza.wt.students_api.exception.StudentNotFoundException;
import tz.ac.suza.wt.students_api.repository.StudentRepository;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<StudentResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(StudentResponseDto::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<StudentResponseDto> findByCourse(String course) {
        return repository.findByCourse(course)
                .stream()
                .map(StudentResponseDto::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public StudentResponseDto findById(Long id) {
        Student s = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return StudentResponseDto.from(s);
    }

    public StudentResponseDto create(StudentCreateDto dto) {
        if (repository.existsByEmail(dto.email())) {
            throw new EmailAlreadyUsedException(dto.email());
        }

        Student s = Student.builder()
                .name(dto.name())
                .email(dto.email())
                .course(dto.course())
                .year(dto.year())
                .createdAt(Instant.now())
                .build();

        return StudentResponseDto.from(repository.save(s));
    }

    public StudentResponseDto update(Long id, StudentUpdateDto dto) {
        Student s = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        if (!s.getEmail().equals(dto.email()) &&
                repository.existsByEmail(dto.email())) {
            throw new EmailAlreadyUsedException(dto.email());
        }

        s.setName(dto.name());
        s.setEmail(dto.email());
        s.setCourse(dto.course());
        s.setYear(dto.year());

        return StudentResponseDto.from(s);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
