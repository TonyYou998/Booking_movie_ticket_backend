package com.example.BookingMovieTicket.Seeders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.example.BookingMovieTicket.HeThongRap.Repository.CumRapRepository;
import com.example.BookingMovieTicket.Phim.Entity.LichChieu;
import com.example.BookingMovieTicket.Phim.Repository.LichChieuRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class SeedLichChieu {
    static long lichChieuId=1;
    private final CumRapRepository cumRapRepository;
    private final LichChieuRepository lichChieuRepository;
    private LocalDate localDate=LocalDate.now();
    private final Logger logger=LoggerFactory.getLogger(this.getClass());
    @EventListener
    @Order(5)
    public void seedLichChieu(ContextRefreshedEvent e){
        logger.info("---------------Starting lich chieu seeder------------------");
        seed();
    }

    private void seed() {
        List<CumRap> lstCumRap=cumRapRepository.findAll();
        for(CumRap cumRap:lstCumRap){
            createLichChieu(cumRap);
        }
    }
    private void createLichChieu(CumRap cumRap){
        List<LichChieu> lstLichChieu=new ArrayList<>();
         for(int i=0;i<7;i++){
          LichChieu lichChieu=new LichChieu();
          lichChieu.setNgayChieu(localDate.plusDays(i));
          lichChieu.setId(lichChieuId);
          lichChieu.setCumRap(cumRap);
        lstLichChieu.add(lichChieu);
            lichChieuId++;
        }
        if(lstLichChieu.size()>0){
            long start=System.currentTimeMillis();
            lichChieuRepository.saveAll(lstLichChieu);
            long end=System.currentTimeMillis();
            logger.info("---------------Process executed in {}ms----------------------", (end - start));
        }
       
    }
}
