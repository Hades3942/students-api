package tz.ac.suza.wt.students_api.config;



import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tz.ac.suza.wt.students_api.entity.Student;
import tz.ac.suza.wt.students_api.repository.StudentRepository;

import java.time.Instant;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedStudents(StudentRepository repository) {
        return args -> {

            if (repository.count() == 0) {

                Student s1 = Student.builder()
                        .name("John Doe")
                        .email("john@suza.ac.tz")
                        .course("Computer Science")
                        .year(2)
                        .createdAt(Instant.now())
                        .build();

                Student s2 = Student.builder()
                        .name("Fatma Ali")
                        .email("fatma@suza.ac.tz")
                        .course("Information Technology")
                        .year(3)
                        .createdAt(Instant.now())
                        .build();

                Student s3 = Student.builder()
                        .name("Juma Hassan")
                        .email("juma@suza.ac.tz")
                        .course("Cybersecurity")
                        .year(1)
                        .createdAt(Instant.now())
                        .build();

                repository.save(s1);
                repository.save(s2);
                repository.save(s3);

                System.out.println("✔ Seeded initial students into database");
            }
        };
    }
}

