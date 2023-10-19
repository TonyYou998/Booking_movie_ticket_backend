package com.example.BookingMovieTicket.Phim.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.BookingMovieTicket.Common.Entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="xuat_chieu")
public class XuatChieu extends BaseEntity{
	@NotNull
	private LocalDateTime thoiGianBatDau;
	@NotNull
	private LocalDateTime thoiGianKetThuc;
	@NotNull
	private LocalDate ngayChieu;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lich_chieu_id")
	private LichChieu lichChieu;
	@OneToMany(mappedBy = "id")
	@JsonIgnore
	private Set<Ve> ve;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="phim_id")
	private Phim phim;


	

}
