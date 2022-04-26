package com.example.BookingMovieTicket.HeThongRap.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import javax.validation.constraints.NotNull;

import com.example.BookingMovieTicket.Common.Entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "he_thong_rap")
@Getter
@Setter
public class HeThongRap extends BaseEntity {
	
	@Column(unique = true)
	@NotNull
	private String tenHeThongRap;
	@NotNull
	private String hinhAnh;
	@JsonIgnore
	@OneToMany(mappedBy = "id")
	private Set<CumRap> cumRap;


}
