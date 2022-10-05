package com.grupo73.grupo73.converters;

import com.grupo73.grupo73.data.UserData;
import com.grupo73.grupo73.entities.User;

public class UserConverter extends Converter<User, UserData> {

    private RoleConverter roleConverter = new RoleConverter();

    @Override
    public User toEntity(UserData object) {
        return object == null ? null : User.builder()
            .id(object.getId())
            .fullname(object.getFullname())
            .nickname(object.getNickname())
            .email(object.getEmail())
            .password(object.getPassword())
            .roles(roleConverter.toEntity(object.getRoles()))
            .registration(object.getRegistration())
            .enabled(object.isEnabled())
            .build();

    }

    @Override
    public UserData toData(User object) {
        return object == null ? null : UserData.builder()
            .id(object.getId())
            .fullname(object.getFullname())
            .nickname(object.getNickname())
            .email(object.getEmail())
            .password(null)
            .roles(roleConverter.toData(object.getRoles()))
            .registration(object.getRegistration())
            .enabled(object.isEnabled())
            .build();
    }
    
}