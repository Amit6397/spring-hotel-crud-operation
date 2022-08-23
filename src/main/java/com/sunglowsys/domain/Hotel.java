package com.sunglowsys.domain;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hotel_code",nullable = false)
    private Long code;

    @Column(name = "hotel_name",nullable = false)
    private String name;

    @Column(name = "hotel_type",nullable = false)
    private String hotelType;

    @Column(name = "hotel_email",nullable = false)
    private String email;

    @Column(name = "hotel_mobile",nullable = true)
    private Integer mobile;

    public Hotel() {
    }

    public Hotel(Long code, String hotelType, String email,Integer mobile) {
        this.code = code;
        this.hotelType = hotelType;
        this.email = email;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id) && Objects.equals(code, hotel.code) && Objects.equals(name, hotel.name) && Objects.equals(hotelType, hotel.hotelType) && Objects.equals(email, hotel.email) && Objects.equals(mobile, hotel.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, hotelType, email, mobile);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", hotel_type='" + hotelType + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
