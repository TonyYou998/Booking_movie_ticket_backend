package com.example.BookingMovieTicket.Common.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
