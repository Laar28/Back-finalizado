package com.grupo73.grupo73.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.grupo73.grupo73.data.RoleData;
import com.grupo73.grupo73.entities.Role;
import com.grupo73.grupo73.converters.RoleConverter;
import com.grupo73.grupo73.repositories.RoleRepository;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository roleRepository;

    private RoleConverter roleConverter = new RoleConverter();

    //Metodo para consultar todos los roles.
    public List<RoleData> findAll() {
        return roleConverter.toData(roleRepository.findAll());
    }

    //Metodo para agregar roles a la bd
    public RoleData insert(RoleData role) {
        if (roleRepository.existsById(role.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El rol ya esta registrado");
        return roleConverter.toData(roleRepository.save(roleConverter.toEntity(role)));
    }

    //Metodo para consultar rol por id
    public RoleData findById(int id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El rol no esta registrado");
        return roleConverter.toData(role.get());
    }

    //Servicio de actualizar
    public RoleData update(RoleData role) {
        if (!roleRepository.existsById(role.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El rol no esta registrado");
        return roleConverter.toData(roleRepository.save(roleConverter.toEntity(role)));
    }

    //Servicio de eliminar por id
    public RoleData deleteById(int id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El rol no esta registrado");
        RoleData roleData = roleConverter.toData(role.get());
        roleRepository.deleteById(id);        
        return roleData;
    }

}