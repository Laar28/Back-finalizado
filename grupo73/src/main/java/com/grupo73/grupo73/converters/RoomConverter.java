package com.grupo73.grupo73.converters;

import com.grupo73.grupo73.data.RoomData;
import com.grupo73.grupo73.entities.Room;

public class RoomConverter extends Converter<Room, RoomData> {

    @Override
    public Room toEntity(RoomData object) {
        return object == null ? null : Room.builder()
            .id(object.getId())
            .name(object.getName())
            .description(object.getDescription())
            .price(object.getPrice())
            .capacity(object.getCapacity())
            .enabled(object.isEnabled())
            .build();

    }

    @Override
    public RoomData toData(Room object) {
        return object == null ? null : RoomData.builder()
            .id(object.getId())
            .name(object.getName())
            .description(object.getDescription())
            .price(object.getPrice())
            .capacity(object.getCapacity())
            .enabled(object.isEnabled())
            .build();
    }
    
}