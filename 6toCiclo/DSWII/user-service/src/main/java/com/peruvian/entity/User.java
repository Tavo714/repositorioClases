package com.peruvian.entity;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
public class User implements Serializable{

private static final long serailVersionUID=1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
    private String firstName;
	
	@Column
    private String lastName;
	
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column
    private String departmentId;
	
    public User() {}

	public User(Long id, String firstName, String lastName, String email, String departmentId) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.departmentId = departmentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public static long getSerailversionuid() {
		return serailVersionUID;
	}
    
    
}
