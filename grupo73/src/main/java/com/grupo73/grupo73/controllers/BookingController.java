package com.grupo73.grupo73.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grupo73.grupo73.data.BookingData;
import com.grupo73.grupo73.services.BookingService;

@RestController
@RequestMapping(path = "/api/bookings")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(bookingService.findAll(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody BookingData booking) {
        return new ResponseEntity<>(bookingService.insert(booking), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(bookingService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody BookingData booking) {
        return new ResponseEntity<>(bookingService.update(booking), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(bookingService.deleteById(id), HttpStatus.OK);
    }

}
