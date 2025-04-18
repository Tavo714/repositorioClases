package com.peruvian.entity;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "departments")
public class Department implements Serializable{
	
	private static final long serailVersionUID=1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
    private String departmentName;
	
	@Column
	private String departmentAddress;
	
	@Column
	private String departmentCode;
	
    public Department() {}

	public Department(Long id, String departmentName, String departmentAddress, String departmentCode) {
		
		this.id = id;
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.departmentCode = departmentCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentAddress() {
		return departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public static long getSerailversionuid() {
		return serailVersionUID;
	}
    
    
}
