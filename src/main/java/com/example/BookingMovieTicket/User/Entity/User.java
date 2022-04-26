package com.example.BookingMovieTicket.User.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.BookingMovieTicket.Common.Entity.BaseEntity;
import com.example.BookingMovieTicket.Phim.Entity.Ve;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@NotNull
	@Column(unique = true)
	private String username;
	
	@NotNull
	@JsonIgnore
	private String password;
	@NotNull
	private String role;
	
	@NotNull
	@Column(unique = true)
	private String email;

	@JsonIgnore
	@OneToMany(mappedBy = "id")
	private Set<Ve> ve =new HashSet<>();

	

}
