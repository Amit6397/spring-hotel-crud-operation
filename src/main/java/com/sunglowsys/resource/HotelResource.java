package com.sunglowsys.resource;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelResource {

    private final HotelService hotelService;

    public HotelResource(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/hotels")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel result = hotelService.save(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @PutMapping("/hotels")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel){
        if (hotel.getId() == null){
            throw new RuntimeException("Hotel must have ID");
        }
        Hotel result = hotelService.update(hotel);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long id){
        Hotel result = hotelService.findOne(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getAllHotel( Long id){
        List<Hotel> hotels = hotelService.findAll(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotels);
    }

    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable("id") Long id){
        hotelService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();


    }
}