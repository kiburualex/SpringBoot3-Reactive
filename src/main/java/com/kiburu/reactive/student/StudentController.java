package com.kiburu.reactive.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    Mono<Student> save(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping
    Flux<Student> findAll(){
        return studentService.findAll()
                .delayElements(Duration.ofSeconds(1));
    }

    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable Integer id){
        return studentService.findById(id);
    }
}
