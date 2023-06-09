package com.task.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tid;
	@NotEmpty(message = "Title cannot be empty")
	private String title;
	@Enumerated(EnumType.STRING)
	private TaskType tasktype;
	private String description;
	private LocalDate date;
	private String status;
	private String createrName;
	@JsonIgnoreProperties("tasks")
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@JsonIgnoreProperties("taskslist")
	@ManyToOne
	@JoinColumn(name = "sprint_id")
	private Sprint sprint;
}
