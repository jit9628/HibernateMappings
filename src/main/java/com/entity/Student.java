package com.entity;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "studentdetail")
public class Student {
	@Id
	@Column(length = 15)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	@Column(length = 25)
	private String sname;
	@Column(length = 25)
	private String email;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JoinColumn(name = "cid")
	private Set<Course> course;
}
