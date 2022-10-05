package com.grupo73.grupo73.converters;

import com.grupo73.grupo73.data.RoleData;
import com.grupo73.grupo73.entities.Role;

public class RoleConverter extends Converter<Role, RoleData>{

    @Override
    public Role toEntity(RoleData object) {
        return object ==  null ? null : Role.builder()
            .id(object.getId())
            .name(object.getName())
            .build();

    }

    @Override
    public RoleData toData(Role object) {
        return object ==  null ? null : RoleData.builder()
            .id(object.getId())
            .name(object.getName())
            .build();
    }
    
}
