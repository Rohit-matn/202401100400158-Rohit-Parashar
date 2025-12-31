package com.example.demo.controller;

import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    // POST /subjects
    @PostMapping
    public Subject addSubject(@RequestBody Subject subject) {
        return service.createSubject(subject);
    }

    // GET /subjects
    @GetMapping
    public List<Subject> getSubjects() {
        return service.getAllSubjects();
    }

    // PUT /subjects/{id}
    @PutMapping("/{id}")
    public Subject updateSubject(
            @PathVariable Long id,
            @RequestBody Subject subject) {
        return service.updateSubject(id, subject);
    }

    // DELETE /subjects/{id}
    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable Long id) {
        service.deleteSubject(id);
        return "Subject deleted successfully";
    }
}

