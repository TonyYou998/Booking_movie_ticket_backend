package com.example.BookingMovieTicket.Common.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	@Id
//	id match csdl
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false,unique = true)
	
	protected Long id;
	@JsonIgnore
	@CreatedDate
	@DateTimeFormat
//	@JsonFormat

	protected LocalDateTime createAt;
	@JsonIgnore
	@LastModifiedDate
	@DateTimeFormat
//	@JsonFormat
	
	protected LocalDateTime updateAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	
	
}
