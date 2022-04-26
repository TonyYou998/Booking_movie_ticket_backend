package com.example.BookingMovieTicket.HeThongRap.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.BookingMovieTicket.Common.Entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="ghe")
public class Ghe extends  BaseEntity{
	@NotNull
	@Column(unique = true)
	private String soGhe;
	@NotNull
	private boolean daDat=false;
	@NotNull
	private  String loaiGhe;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="rap_id")
	private Rap rap;
	
	

}
