package com.example.BookingMovieTicket.HeThongRap.Entity;

import java.util.List;
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
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "rap")
public class Rap extends BaseEntity{
	@NotNull
	@Column(columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci")
	private String tenRap;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cum_rap_id")
	@JsonBackReference
	private CumRap cumRap;
	@OneToMany(mappedBy = "rap")
	@Column(name="danhSachGhe")
	private List<Ghe> danhSachGhe;

	
	

}
