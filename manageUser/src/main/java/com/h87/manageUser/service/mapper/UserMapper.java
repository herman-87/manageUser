package com.h87.manageUser.service.mapper;

import com.h87.manageUser.utils.RegisterUserData;
import com.manageUser.model.RegisterUserDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
@Component
public interface UserMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "emailAddress")
    @Mapping(target = "password")
    @Mapping(target = "countryCode")
    @Mapping(target = "number")
    @Mapping(target = "firstName")
    @Mapping(target = "lastName")
    @Mapping(target = "dateOfBirth")
    @Mapping(target = "genre")
    RegisterUserData fromRegisterUserDTOToRegisterUserData(RegisterUserDTO registerUserDTO);
}
