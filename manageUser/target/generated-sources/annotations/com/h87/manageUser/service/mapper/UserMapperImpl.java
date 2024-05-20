package com.h87.manageUser.service.mapper;

import com.h87.manageUser.domain.users.Genre;
import com.h87.manageUser.utils.RegisterUserData;
import com.manageUser.model.GenreDTO;
import com.manageUser.model.RegisterUserDTO;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-20T13:19:03+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public RegisterUserData fromRegisterUserDTOToRegisterUserData(RegisterUserDTO registerUserDTO) {
        if ( registerUserDTO == null ) {
            return null;
        }

        String emailAddress = null;
        String password = null;
        String countryCode = null;
        String number = null;
        String firstName = null;
        String lastName = null;
        LocalDate dateOfBirth = null;
        Genre genre = null;

        emailAddress = registerUserDTO.getEmailAddress();
        password = registerUserDTO.getPassword();
        countryCode = registerUserDTO.getCountryCode();
        number = registerUserDTO.getNumber();
        firstName = registerUserDTO.getFirstName();
        lastName = registerUserDTO.getLastName();
        dateOfBirth = registerUserDTO.getDateOfBirth();
        genre = genreDTOToGenre( registerUserDTO.getGenre() );

        RegisterUserData registerUserData = new RegisterUserData( emailAddress, password, countryCode, number, firstName, lastName, dateOfBirth, genre );

        return registerUserData;
    }

    protected Genre genreDTOToGenre(GenreDTO genreDTO) {
        if ( genreDTO == null ) {
            return null;
        }

        Genre genre;

        switch ( genreDTO ) {
            case MALE: genre = Genre.MALE;
            break;
            case FEMALE: genre = Genre.FEMALE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + genreDTO );
        }

        return genre;
    }
}
