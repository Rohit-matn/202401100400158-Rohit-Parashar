package com.example.demo.service;

import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository repository;

    public SubjectService(SubjectRepository repository) {
        this.repository = repository;
    }

    public Subject createSubject(Subject subject) {
        return repository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return repository.findAll();
    }

    public Subject updateSubject(Long id, Subject updatedSubject) {
        Subject subject = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        subject.setSubjectCode(updatedSubject.getSubjectCode());
        subject.setSubjectName(updatedSubject.getSubjectName());

        return repository.save(subject);
    }

    public void deleteSubject(Long id) {
        repository.deleteById(id);
    }
}
