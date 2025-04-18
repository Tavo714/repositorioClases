package com.peruvian.service;

import com.peruvian.entity.Department;
import java.util.Collection;

public interface DepartmentService {

	public abstract void insert(Department department);

    public abstract Department findById(Long Id);
    
}
