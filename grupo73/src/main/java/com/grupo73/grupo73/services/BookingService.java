package com.grupo73.grupo73.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.grupo73.grupo73.converters.BookingConverter;
import com.grupo73.grupo73.data.BookingData;
import com.grupo73.grupo73.entities.Booking;
import com.grupo73.grupo73.repositories.BookingRepository;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;

    private BookingConverter bookingConverter = new BookingConverter();

    //Metodo para consultar todas las reservas.
    public List<BookingData> findAll() {
        return bookingConverter.toData(bookingRepository.findAll());
    }

    //Metodo para agregar reservas a la bd
    public BookingData insert(BookingData booking) {
        if (bookingRepository.existsById(booking.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "La reserva ya esta registrada");
        return bookingConverter.toData(bookingRepository.save(bookingConverter.toEntity(booking)));
    }

    //Metodo para consultar rol por id
    public BookingData findById(int id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La reserva no esta registrada");
        return bookingConverter.toData(booking.get());
    }

    //Servicio de actualizar
    public BookingData update(BookingData booking) {
        if (!bookingRepository.existsById(booking.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La reserva no esta registrada");
        return bookingConverter.toData(bookingRepository.save(bookingConverter.toEntity(booking)));
    }

       //Servicio de eliminar por id
       public BookingData deleteById(int id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El rol no esta registrado");
        BookingData bookingData = bookingConverter.toData(booking.get());
        bookingRepository.deleteById(id);        
        return bookingData;
    }

}