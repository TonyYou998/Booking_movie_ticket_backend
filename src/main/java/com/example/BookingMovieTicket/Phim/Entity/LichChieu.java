package com.example.BookingMovieTicket.Phim.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.BookingMovieTicket.Common.Entity.BaseEntity;
import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="lich_chieu")
public class LichChieu extends BaseEntity {
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cum_rap_id")
	private CumRap cumRap;
	
	private LocalDate ngayChieu;
	
	// @OneToMany(mappedBy = "lichChieu")
	// private List<Phim> phim=new HashSet<Phim>();
	// mapped to name of property in the inverse table not name of this table 

	@JsonIgnore
	@ManyToMany(mappedBy = "lichChieu",fetch=FetchType.LAZY)
	private List<Phim> phim=new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id")
	private Set<XuatChieu> xuatChieu;
	private boolean isCompleted=false;

}
