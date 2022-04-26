package com.example.BookingMovieTicket.Phim.Entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@JoinColumn(name = "cum_rap_id")
	private CumRap cumRap;
	
	private LocalDateTime ngayChieu;
	
//	@OneToMany(mappedBy = "id")
//	private Set<Phim> phim=new HashSet<Phim>();
//	mapped to name of property in the inverse table not name of this table 
	@JsonIgnore
	@ManyToMany(mappedBy = "lichChieu",fetch=FetchType.LAZY)
	private Set<Phim> phim=new HashSet<Phim>();
	@JsonIgnore
	@OneToMany(mappedBy = "id")
	private Set<XuatChieu> xuatChieu;



//	public void addPhim(Phim phim) {
//		this.phim.add(phim);
//		
//		
//	}


	

}
