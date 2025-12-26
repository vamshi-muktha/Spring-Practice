package com.tcs.SpringWithJpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.SpringWithJpa.bean.Dept;
import com.tcs.SpringWithJpa.service.DeptService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/save")
    public ResponseEntity<Dept> saveDept(@Valid @RequestBody Dept dept) {
        Dept saved = deptService.save(dept);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Dept>> getAll() {
        return new ResponseEntity<>(deptService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dept> getById(@PathVariable String id) {
        Optional<Dept> found = deptService.findById(id);
        return found.map(d -> new ResponseEntity<>(d, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteById(@RequestParam String id) {
        boolean deleted = deptService.deleteById(id);
        if (deleted) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Dept> update(@RequestBody Dept dept) {
        Dept updated = deptService.update(dept);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
