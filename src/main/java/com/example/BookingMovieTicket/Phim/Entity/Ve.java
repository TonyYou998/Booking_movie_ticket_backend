package com.example.BookingMovieTicket.Phim.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.BookingMovieTicket.Common.Entity.BaseEntity;
import com.example.BookingMovieTicket.User.Entity.User;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="ve")
public class Ve extends BaseEntity  {
	@NotNull
	private Integer giaVe;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="xuat_chieu_id")
	private XuatChieu xuaChieu;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	
	private User user;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "phim_id") 
	private Phim phim;


	

}
