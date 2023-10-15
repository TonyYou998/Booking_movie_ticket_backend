package com.example.BookingMovieTicket.Seeders;

import antlr.Parser;
import com.example.BookingMovieTicket.Common.utils.ReadFile;
import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.example.BookingMovieTicket.HeThongRap.Entity.HeThongRap;
import com.example.BookingMovieTicket.HeThongRap.Repository.CumRapRepository;
import lombok.AllArgsConstructor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Component
@Transactional
@AllArgsConstructor
public class CumRapSeeder {
    private CumRapRepository repository;
    static long index=1;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final Logger logger =LoggerFactory.getLogger(this.getClass());

    final String cgv="D:\\MyWorkspace\\Java\\Booking_movie_ticket_backend\\src\\main\\resources\\cgv-cum-rap.json";
    final String bhd="D:\\MyWorkspace\\Java\\Booking_movie_ticket_backend\\src\\main\\resources\\bhd-cum-rap.json";
    final String cinestar="D:\\MyWorkspace\\Java\\Booking_movie_ticket_backend\\src\\main\\resources\\cinestar-cum-rap.json";
    final String galaxy="D:\\MyWorkspace\\Java\\Booking_movie_ticket_backend\\src\\main\\resources\\galaxy-cum-rap.json";


    @EventListener
    @Order(2)
    public void cumRapSeeder(ContextRefreshedEvent event)  {
       logger.info("-------------------------running cum rap seeder-----------------------");
        seedCumRap();
    }

    private void seedCumRap()  {
        List<CumRap> lstCumRap=repository.findAll();
        String query="SELECT * FROM he_thong_rap";
    //   List<HeThongRap> lstHTR=jdbcTemplate.query(query, new RowMapper<HeThongRap>() {
    //        @Override
    //        public HeThongRap mapRow(ResultSet resultSet, int i) throws SQLException {
    //            HeThongRap heThongRap=new HeThongRap();
    //            heThongRap.setId(resultSet.getLong("id"));
    //            heThongRap.setTenHeThongRap(resultSet.getString("ten_he_thong_rap"));
    //            heThongRap.setHinhAnh(resultSet.getString("hinh_anh"));
    //            return  heThongRap;
    //        }
    //    });
        List<HeThongRap> lstHTR=jdbcTemplate.query(query,( java.sql.ResultSet resultSet,int i)->{
            HeThongRap heThongRap=new HeThongRap();
                heThongRap.setId(resultSet.getLong("id"));
                heThongRap.setTenHeThongRap(resultSet.getString("ten_he_thong_rap"));
                heThongRap.setHinhAnh(resultSet.getString("hinh_anh"));
                return  heThongRap;

        });
        if(lstCumRap.size()<1) {
            List<String> listCumRapRaw=new ArrayList<>();
            listCumRapRaw.add(cgv);
            listCumRapRaw.add(bhd);
            listCumRapRaw.add(cinestar);
            listCumRapRaw.add(galaxy);
            int maHeThongRap=0;
            for(String item:listCumRapRaw){

                seed(item,maHeThongRap,lstHTR);
                maHeThongRap++;
            }




        }

    }
    private void seed(String fileSeed,int maHeThongRap,List<HeThongRap> lstHTR){
        try {
            String jsonString= ReadFile.readJSon(fileSeed);
            JSONParser parser=new JSONParser();
            JSONArray jsonArray=(JSONArray) parser.parse(jsonString);

            Set<CumRap> setCumRAp=new LinkedHashSet<>();
            for (Object object : jsonArray) {
                // Tạo đối tượng JSONObject
                JSONObject jsonObject = (JSONObject) object;
                CumRap newCumRap=new CumRap();
                newCumRap.setId(index);
                newCumRap.setTenCumRap(jsonObject.get("tenCumRap").toString());
                newCumRap.setHeThongRap(lstHTR.get(maHeThongRap));
                newCumRap.setDiaChi(jsonObject.get("diaChi").toString());
                newCumRap.setHinhAnh("https://www.cgv.vn/media/site/cache/1/980x415/b58515f018eb873dafa430b6f9ae0c1e/a/b/abt-2_1.png");
                setCumRAp.add(newCumRap);

                index++;
            }
            long start=System.currentTimeMillis();
            repository.saveAll(setCumRAp);
            long end=System.currentTimeMillis();
            logger.info("---------------Process executed in {}ms----------------------", (end - start));

        }
        catch (Exception e) {
            logger.info(e.getMessage());
            logger.info("Cannot find Cum Rap seed file");
        }


    }
}
