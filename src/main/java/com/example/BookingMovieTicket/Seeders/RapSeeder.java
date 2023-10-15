package com.example.BookingMovieTicket.Seeders;

import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.example.BookingMovieTicket.HeThongRap.Entity.Rap;
import com.example.BookingMovieTicket.HeThongRap.Repository.CumRapRepository;
import com.example.BookingMovieTicket.HeThongRap.Repository.RapRepository;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@AllArgsConstructor
public class RapSeeder {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    private  RapRepository rapRepository;

    private CumRapRepository cumRapRepository;

    @EventListener
    @Order(3)
    public void rapSeeder(ContextRefreshedEvent event){
        logger.info("---------------------running rap seeder--------------------");
        seedRap();

    }

    private void seedRap() {
        String query="SELECT * FROM cum_rap";
        List<Rap> lstRap=rapRepository.findAll();
        if(lstRap.size()<1){
            List<CumRap> lstCumRap=cumRapRepository.findAll();
            if(lstCumRap.size()!=0){
                int indexCumRap=0;
                long indexRap=1;
                long indexTenRap=1;
                while(indexTenRap<=5&&indexCumRap<lstCumRap.size()){
                    Rap rap=new Rap();
                    rap.setId(indexRap);
                    rap.setTenRap("Rạp số "+String.valueOf(indexTenRap));
                    rap.setCumRap(lstCumRap.get(indexCumRap));
                    indexRap++;
                    indexTenRap++;
                    lstRap.add(rap);
                    if(indexTenRap==6){
                        indexCumRap++;
                        indexTenRap=1;
                    }
                }
            }
            if(lstRap.size()>0)
                rapRepository.saveAll(lstRap);

        }



    }
}
