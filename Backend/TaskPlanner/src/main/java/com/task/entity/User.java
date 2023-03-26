package com.task.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uid;
	@Email(message = "Email formate not valid")
	private String email;
	private String name;
	private String role;
	private String password;
	@JsonIgnoreProperties("user")
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Task> tasks=new ArrayList<>();
	
}
