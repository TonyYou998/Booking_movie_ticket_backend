package com.example.BookingMovieTicket.Phim.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.BookingMovieTicket.Phim.Dto.AddPhimDto;
import com.example.BookingMovieTicket.Phim.Dto.AddPhimLichChieuDto;
import com.example.BookingMovieTicket.Phim.Dto.PhimDto;
import com.example.BookingMovieTicket.Phim.Dto.addLichChieuDto;

import com.example.BookingMovieTicket.Phim.Entity.LichChieu;
import com.example.BookingMovieTicket.Phim.Entity.Phim;
import com.example.BookingMovieTicket.Phim.Service.PhimService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1")
public class PhimController {
	PhimService phimService;
	private final String uploadDir="/src/main/resources/static/upload/";
	private final String domainName="http://localhost:8080/";
//	private final String domainName="https://bookingmovieapi.herokuapp.com/";

	public  PhimController(PhimService phimService) {
		// TODO Auto-generated constructor stub
		this.phimService=phimService;
	}
	@PostMapping("/admin/phim/add")
	public Object addPhim( @RequestParam("addPhimDto") String model,@RequestParam("file") MultipartFile file) {
		try {
			ObjectMapper mapper= new  ObjectMapper();
			mapper.findAndRegisterModules();
			AddPhimDto dto=mapper.readValue(model, AddPhimDto.class);
			
			String fileName=file.getOriginalFilename();
			String userDirectory=Paths.get("").toAbsolutePath().toString();
			Path folderPath=Paths.get(userDirectory+uploadDir);
			if(!Files.exists(folderPath))
					Files.createDirectories(folderPath);
			Path path=Paths.get(userDirectory+uploadDir+fileName);
			Files.write(path, file.getBytes());
			final String savedPath=domainName+fileName;
			dto.setHinhAnh(savedPath);
			Phim newPhim=phimService.addNewPhim(dto);
			return newPhim;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return "loi";
		}
		

		
	}
	@GetMapping("/user/phim/get-phim")
	public Object getPhim() {
		  List<PhimDto> dsPhim=phimService.getAllPhim();
		  return dsPhim;
		
	}
	@PostMapping("/admin/phim/lichchieu")
	public Object addLichChieu(@Valid @RequestBody addLichChieuDto dto) {
		LichChieu newLichChieu=phimService.addLichChieu(dto);
		
		return newLichChieu;
	}
	@PostMapping("/admin/phim/add-phim-lich-chieu/add")
	public Object addPhimLichChieu(@Valid @RequestBody AddPhimLichChieuDto dto,BindingResult result) {
			if(result.hasErrors()) {
				return "loi";
			}
			Phim newPhim=phimService.addPhimLichChieu(dto);
		
		return dto;
		
		
	}
	@GetMapping("/user/phim/lich-chieu/{id}")
	public Object getPhimTheoLichChieu(@PathVariable("id") Long id ) {
		
		List<Phim> lstPhim=phimService.getPhimByLichChieuId(id);
		
		return lstPhim;
	}
	@GetMapping("/user/cum-rap/{id}")
	public Object getPhimTheoCumRap(@PathVariable("id") Long cum_rap_id) {
		List<Phim> lstPhim=phimService.getPhimByCumRapId(cum_rap_id);
		return lstPhim;
		
		
	}
	@GetMapping("/{id}")
	public Object getDetailPhim(@PathVariable("id") Long id) {
		Phim phim=phimService.getPhimById(id);
		return phim;
		
		
	}
	
	

}
