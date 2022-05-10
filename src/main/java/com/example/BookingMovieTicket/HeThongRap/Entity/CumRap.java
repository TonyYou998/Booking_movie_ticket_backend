package com.example.BookingMovieTicket.HeThongRap.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

import com.example.BookingMovieTicket.Common.Entity.BaseEntity;
import com.example.BookingMovieTicket.Phim.Entity.LichChieu;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "cum_rap")
public class CumRap extends BaseEntity {
	@NotNull
	@Column(unique = true)
	private String tenCumRap;
	@NotNull
	private String hinhAnh;
	@NotNull
	@Column(unique = true)
	private String diaChi;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "he_thong_rap_id")
	private HeThongRap heThongRap;
	@JsonIgnore
	@OneToMany(mappedBy = "id")
	private Set<Rap> rap;
//	@JsonIgnore
//	@OneToOne(cascade =CascadeType.ALL)
//	@JoinColumn(name="lich_chieu_id",referencedColumnName = "id")
//	private LichChieu  lichChieu;

	

}
