package com.example.BookingMovieTicket.Phim.Entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.example.BookingMovieTicket.Common.Entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name="phim")
public class Phim extends BaseEntity {
	@NotNull
	@Column(columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci")
	private String tenPhim;
	@NotNull
	@Column(columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci")
	private String theLoai;
	@NotNull
	private Integer doTuoi;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinTable(name="phim_lich_chieu",joinColumns = {
			@JoinColumn(name="phim_id",referencedColumnName = "id",nullable = true,updatable = true)
	},inverseJoinColumns = {
			@JoinColumn(name="lich_chieu_id",referencedColumnName = "id",nullable = true,updatable = true)
	})
	@JsonIgnore
	@Builder.Default
	private Set<LichChieu> lichChieu=new HashSet<LichChieu>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id")
	private Set<XuatChieu> xuatChieu;

	private String moTa;
	@NotNull
	private String hinhAnh;
	
	@NotNull
	private String trailer;
	@NotNull
	private LocalDateTime ngayPhatHanh;
	private Integer rating;
//	@JsonIgnore
//	@OneToMany(mappedBy = "id")
//	private List<Ve> ve;
	
	public void setPhimLichChieu(LichChieu lichChieu) {
		this.lichChieu.add(lichChieu);
		lichChieu.getPhim().add(this);
	}
	
	

	

}
