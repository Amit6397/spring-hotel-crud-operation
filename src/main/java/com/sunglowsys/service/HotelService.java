package com.sunglowsys.service;

import com.sunglowsys.domain.Hotel;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    Hotel save(Hotel hotel);

    Hotel update(Hotel hotel);

    Optional<Hotel> findOne(Long id);

    List<Hotel> findAll(Long id);

    void delete(Long id);
}
