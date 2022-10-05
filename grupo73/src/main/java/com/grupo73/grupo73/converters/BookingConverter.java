package com.grupo73.grupo73.converters;

import com.grupo73.grupo73.data.BookingData;
import com.grupo73.grupo73.entities.Booking;

public class BookingConverter extends Converter<Booking, BookingData>{

    RoomConverter roomConverter = new RoomConverter();
    UserConverter userConverter = new UserConverter();

    @Override
    public Booking toEntity(BookingData object) {
        return object == null ? null : Booking.builder()
            .id(object.getId())
            .room(roomConverter.toEntity(object.getRoom())) 
            .user(userConverter.toEntity(object.getUser()))
            .date(object.getDate())
            .dateBegin(object.getDateBegin())
            .DateFinish(object.getDateFinish())
            .build();

    }

    @Override
    public BookingData toData(Booking object) {
        return object == null ? null : BookingData.builder()
            .id(object.getId())
            .room(roomConverter.toData(object.getRoom()))
            .user(userConverter.toData(object.getUser()))
            .date(object.getDate())
            .dateBegin(object.getDateBegin())
            .DateFinish(object.getDateFinish())
            .build();
    }
    
}