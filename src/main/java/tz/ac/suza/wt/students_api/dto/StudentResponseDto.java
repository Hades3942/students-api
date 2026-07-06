package tz.ac.suza.wt.students_api.dto;

import tz.ac.suza.wt.students_api.entity.Student;
import java.time.Instant;

public record StudentResponseDto(
        Long id,
        String name,
        String email,
        String course,
        Integer year,
        Instant createdAt
) {
    public static StudentResponseDto from(Student s) {
        return new StudentResponseDto(
                s.getId(),
                s.getName(),
                s.getEmail(),
                s.getCourse(),
                s.getYear(),
                s.getCreatedAt()
        );
    }
}
