package com.kiburu.reactive;

import com.kiburu.reactive.student.Student;
import com.kiburu.reactive.student.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentService studentService){
		return args -> {
			for(int i = 0; i < 100; i++){
				studentService.save(
						Student.builder()
								.firstname("Alex " + i)
								.lastname("Kiburu " + i)
								.age(i)
								.build()
				).subscribe();
			}
		};
	}

}
