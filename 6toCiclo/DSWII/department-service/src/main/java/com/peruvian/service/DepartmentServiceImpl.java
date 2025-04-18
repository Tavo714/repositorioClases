package com.peruvian.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import com.peruvian.entity.Department;
import com.peruvian.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository repository;

    @Override
    @Transactional
    public void insert(Department department) {
        repository.save(department);
    }

    @Override
    @Transactional(readOnly=true)
    public Department findById(Long Id) {
        return repository.findById(Id).orElse(null);
    }

}
