package com.example.BookingMovieTicket.Seeders;

import com.example.BookingMovieTicket.HeThongRap.Entity.Ghe;
import com.example.BookingMovieTicket.HeThongRap.Entity.Rap;
import com.example.BookingMovieTicket.HeThongRap.Repository.GheRepository;
import com.example.BookingMovieTicket.HeThongRap.Repository.RapRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Transactional
@Component
public class GheSeeder {
    RapRepository rapRepository;
    GheRepository gheRepository;
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @EventListener
    @Order(4)
    public void gheSeeder(ContextRefreshedEvent event){
        logger.info("---------------Starting ghe seeder------------------");
        List<Ghe> lstGhe=gheRepository.findAll();
         if(lstGhe.size()<1)
            seed();
    }

    private void seed() {
        List<Ghe> lstGhe=new ArrayList<>();
        List<Rap> lstRap=rapRepository.findAll();
        if(lstRap.size()!=0){
            long indexGhe=1;
            int indexRap=0;
            int indexTenGhe=1;
            while(indexTenGhe<=150&&indexRap<lstRap.size()){
                Ghe ghe=new Ghe();
                ghe.setId(indexGhe);
                ghe.setSoGhe("Ghế "+String.valueOf(indexTenGhe));
                ghe.setLoaiGhe("VIP");
                ghe.setRap(lstRap.get(indexRap));
                indexGhe++;
                indexTenGhe++;
                lstGhe.add(ghe);
                if(indexTenGhe==151){
                    indexRap++;
                    indexTenGhe=1;
                }

            }
        }
        if(lstGhe.size()!=0){
            long start=System.currentTimeMillis();
            gheRepository.saveAll(lstGhe);
            long end=System.currentTimeMillis();
            logger.info("---------------Process executed in {}ms----------------------", (end - start));
        }

    }

}
