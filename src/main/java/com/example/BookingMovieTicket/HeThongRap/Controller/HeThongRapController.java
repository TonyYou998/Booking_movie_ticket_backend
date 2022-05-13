package com.example.BookingMovieTicket.HeThongRap.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.BookingMovieTicket.HeThongRap.Dto.CreateHeThongRapDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.example.BookingMovieTicket.HeThongRap.Entity.HeThongRap;
import com.example.BookingMovieTicket.HeThongRap.Service.CumRapService;
import com.example.BookingMovieTicket.HeThongRap.Service.HeThongRapService;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@RequestMapping("/api/v1")
public class HeThongRapController {
	
	private HeThongRapService heThongRapService;
	private final String uploadDir="/src/main/resources/static/";

	public HeThongRapController(HeThongRapService heThongRapService ) {
		// TODO Auto-generated constructor stub
		this.heThongRapService=heThongRapService;
		
		
	}
	@PostMapping("/admin/he-thong-rap/create")
	public Object createHeThongRap( @RequestParam("createHeThongRapDto") String model,@RequestParam("file") MultipartFile file){
		
		
		
		try {
			ObjectMapper mapper=new ObjectMapper();
			CreateHeThongRapDto dto=mapper.readValue(model, CreateHeThongRapDto.class);
		
			String fileName=file.getOriginalFilename();
//			duong dan toi thu muc chua prj
			String userDirectory=Paths.get("").toAbsolutePath().toString();
			Path folderPath=Paths.get(userDirectory+uploadDir);
			if(!Files.exists(folderPath)) {
				Files.createDirectories(folderPath);
			}
			Path path=Paths.get(userDirectory+uploadDir+fileName);
			String savedPath=path.toAbsolutePath().toString();
			
			
			Files.write(path, file.getBytes());
			HeThongRap newHeThongRap=heThongRapService.createHeThongRap(dto,savedPath);
			return newHeThongRap;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "loi";
		}
	
		
		
		
		
	}
	@GetMapping("/user/he-thong-rap/getall")
	public Object getHeThongRap() {
		 List <HeThongRap> lstHeThongRap=heThongRapService.getAllHeThongRap();
		 return lstHeThongRap;
		
	}
//	@PostMapping("/user/he-thong-rap/upload")
//	public Object uploadHeThongRapLogo(@RequestParam("file") MultipartFile file) {
//		try {
//			String fileName=file.getOriginalFilename();
////			duong dan toi thu muc chua prj
//			String userDirectory=Paths.get("").toAbsolutePath().toString();
//			Path folderPath=Paths.get(userDirectory+uploadDir);
//			if(!Files.exists(folderPath)) {
//				Files.createDirectories(folderPath);
//			}
//			Path path=Paths.get(userDirectory+uploadDir+fileName);
//			
//			Files.write(path, file.getBytes());
//			return "upload success";
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return "loi";
//		}
//		
//		
//	}
	

}
