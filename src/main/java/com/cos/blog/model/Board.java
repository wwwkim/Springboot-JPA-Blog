package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//auto_increment
	private int id;
	
	@Column(nullable=false,length=100)
	private String title;
	
	@Lob//Big size data
	private String content;
	
	@ColumnDefault("0")
	private int count;
		
	@ManyToOne(fetch=FetchType.EAGER)//Many=Board, One=User
	@JoinColumn(name="userId")
	private User user;//FK

	@OneToMany(mappedBy = "board",fetch=FetchType.EAGER)//mappedBy:I'm not FK .Don't make column at DB
	private List<Reply> reply;
	
	@CreationTimestamp//auto
	private Timestamp createDate;
	
}
