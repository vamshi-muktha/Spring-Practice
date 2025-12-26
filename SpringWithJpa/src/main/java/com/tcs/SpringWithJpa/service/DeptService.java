package com.tcs.SpringWithJpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.SpringWithJpa.bean.Dept;
import com.tcs.SpringWithJpa.repo.DeptRepo;

@Service
public class DeptService {

    @Autowired
    private DeptRepo deptRepo;

    public Dept save(Dept dept) {
        return deptRepo.save(dept);
    }

    public Optional<Dept> findById(String id) {
        return deptRepo.findById(id);
    }

    public List<Dept> findAll() {
        return deptRepo.findAll();
    }

    public boolean deleteById(String id) {
        if (!deptRepo.existsById(id)) return false;
        deptRepo.deleteById(id);
        return true;
    }

    public Dept update(Dept dept) {
        return deptRepo.save(dept);
    }
}
