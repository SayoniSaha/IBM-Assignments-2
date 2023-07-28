package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "department_table")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private int departmentId;
	@Column(name = "department_name")
	private String departmentName;
	@Column(name = "department_location")
	private String location;

	public Department(String departmentName, String location) {
		super();
		this.departmentName = departmentName;
		this.location = location;
	}

}
