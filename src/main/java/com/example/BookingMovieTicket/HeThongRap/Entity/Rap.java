package com.example.BookingMovieTicket.HeThongRap.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.BookingMovieTicket.Common.Entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "rap")
public class Rap extends BaseEntity{
	@NotNull
	@Column(unique = true)
	private String tenRap;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cum_rap_id")
	private CumRap cumRap;
	@OneToMany(mappedBy = "id")
	private Set<Ghe> ghe;

	
	

}
