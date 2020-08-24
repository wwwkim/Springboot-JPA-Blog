package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class User {
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Depend on DB numbering
	private int id;// auto_increment
	
	@Column(nullable = false, length = 30)
	private String username;// id
	
	@Column(nullable = false, length = 100) // 12345=>暗号化するため
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role;// admin,user,manager権限
	
	@CreationTimestamp // auto
	private Timestamp createDate;
}
