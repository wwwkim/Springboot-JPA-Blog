package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@DynamicInsert　： insertする時null fild除外
public class User {
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Depend on DB numbering
	private int id;// auto_increment
	
	@Column(nullable = false, length = 30, unique=true)
	private String username;// id
	
	@Column(nullable = false, length = 100) // 12345=>暗号化するため
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
//	@ColumnDefault("'user'")
	@Enumerated(EnumType.STRING)
	private RoleType role;// Enum :ADMIN,USER
	
	@CreationTimestamp // auto
	private Timestamp createDate;
}
