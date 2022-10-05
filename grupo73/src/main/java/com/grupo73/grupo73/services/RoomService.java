package com.grupo73.grupo73.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.grupo73.grupo73.converters.RoomConverter;
import com.grupo73.grupo73.data.RoomData;
import com.grupo73.grupo73.entities.Room;
import com.grupo73.grupo73.repositories.RoomRepository;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;

    private RoomConverter roomConverter = new RoomConverter();

    //Metodo para consultar todos los roles.
    public List<RoomData> findAll() {
        return roomConverter.toData(roomRepository.findAll());
    }

    //Metodo para agregar roles a la bd
    public RoomData insert(RoomData room) {
        if (roomRepository.existsById(room.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El salon ya esta registrado");
        return roomConverter.toData(roomRepository.save(roomConverter.toEntity(room)));
    }

    //Metodo para consultar rol por id
    public RoomData findById(int id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El salon no esta registrado");
        return roomConverter.toData(room.get());
    }

    //Servicio de actualizar
    public RoomData update(RoomData room) {
        if (!roomRepository.existsById(room.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El salon no esta registrado");
        return roomConverter.toData(roomRepository.save(roomConverter.toEntity(room)));
    }

    //Servicio de eliminar por id
    public RoomData deleteById(int id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El salon no esta registrado");
        RoomData roomData = roomConverter.toData(room.get());
        roomRepository.deleteById(id);        
        return roomData;
    }

}
