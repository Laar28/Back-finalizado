package com.grupo73.grupo73.data;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingData {

    private int id;
    private RoomData room;
    private UserData user;
    private Date date;
    private Date dateBegin;
    private Date DateFinish;

}