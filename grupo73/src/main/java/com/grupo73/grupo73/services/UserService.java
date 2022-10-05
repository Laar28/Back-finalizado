package com.grupo73.grupo73.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.grupo73.grupo73.data.UserData;
import com.grupo73.grupo73.entities.User;
import com.grupo73.grupo73.converters.UserConverter;
import com.grupo73.grupo73.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private UserConverter userConverter = new UserConverter();

     //Metodo para consultar todos los usuarios.
     public List<UserData> findAll() {
        return userConverter.toData(userRepository.findAll());
     }

     //Metodo para agregar usuarios a la bd
    public UserData insert(UserData user) {
        if (userRepository.existsById(user.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El usuario ya esta registrado");
        return userConverter.toData(userRepository.save(userConverter.toEntity(user)));
    }

     //Metodo para consultar user por id
    public UserData findById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no esta registrado");
        return userConverter.toData(user.get());
    }

    //Servicio de actualizar
    public UserData update(UserData user) {
        if (!userRepository.existsById(user.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no esta registrado");
        return userConverter.toData(userRepository.save(userConverter.toEntity(user)));
    }

    //Servicio de eliminar por id
    public UserData deleteById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no esta registrado");
        UserData userData = userConverter.toData(user.get());
        userRepository.deleteById(id);        
        return userData;
    }

}