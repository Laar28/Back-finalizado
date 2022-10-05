package com.grupo73.grupo73.data;

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
public class RoomData {
    
    private int id;
    private String name;
    private String description;
    private double price;
    private int capacity;
    private boolean enabled;

}