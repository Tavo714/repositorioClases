package com.peruvian.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import com.peruvian.entity.Department;
import com.peruvian.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController  {
	
	@Autowired
	private DepartmentService departmentService;

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Department department){
        departmentService.insert(department);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listar(@PathVariable("id") Long id){
    	
    	Department departmentDb = departmentService.findById(id);
    	
    	if (departmentDb!=null) {
    		return new ResponseEntity<>(departmentDb, HttpStatus.OK);
    	}
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
