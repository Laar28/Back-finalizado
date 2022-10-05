package com.grupo73.grupo73.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo73.grupo73.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
    
}
