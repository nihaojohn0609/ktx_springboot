package com.example.korail.repository;

import com.example.korail.dto.OrderDto;
import com.example.korail.dto.ReservationDto;
import com.example.korail.dto.SeatNumberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
@Mapper
public interface OrderMapper {
    int selectcard(String cardnum,String email);
    ArrayList<OrderDto> select(OrderDto orderDto);
    int payment(OrderDto orderDto);
    List<SeatNumberDto> seatnum(ReservationDto rvo);
}
