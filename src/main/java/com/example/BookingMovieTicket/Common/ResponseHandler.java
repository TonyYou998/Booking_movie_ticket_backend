package com.example.BookingMovieTicket.Common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.example.BookingMovieTicket.Common.utils.ErrorUtil;

public class ResponseHandler {
	public static ResponseEntity<Object> getResponse(Object content,HttpStatus status){
		Map<String,Object> map=new HashMap<>();
		map.put("content", content);
		map.put("error", "");
//		map.put("timestamp", DateUtils.toString(LocalDateTime.now()));
		map.put("status", status.value());
		return new ResponseEntity<Object>(map,status);
		
	}
	public static ResponseEntity<Object> getResponse(BindingResult errors, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", "");
		map.put("errors", ErrorUtil.getErrorMessages(errors));
//		map.put("timestamp", DateUtils.toString(LocalDateTime.now()));
		map.put("status", status.value());
		
		return new ResponseEntity<Object>(map, status);
	}
	public static Object getResponse(HttpStatus status) {
		Map<String, Object> map = new HashMap<>();
		map.put("content", "");
		map.put("errors", "");
//		map.put("timestamp", DateUtils.toString(LocalDateTime.now()));
		map.put("status", status.value());
		
		return new ResponseEntity<Object>(map, status);
	}

}
