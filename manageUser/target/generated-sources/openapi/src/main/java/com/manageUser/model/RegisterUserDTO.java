package com.manageUser.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.manageUser.model.GenreDTO;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * RegisterUserDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-20T11:51:14.082200125+01:00[Africa/Douala]")
public class RegisterUserDTO {

  private String emailAddress;

  private String password;

  private String countryCode;

  private String number;

  private String firstName;

  private String lastName;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateOfBirth;

  private GenreDTO genre;

  public RegisterUserDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RegisterUserDTO(String emailAddress, String password, String countryCode, String number, String firstName, String lastName, GenreDTO genre) {
    this.emailAddress = emailAddress;
    this.password = password;
    this.countryCode = countryCode;
    this.number = number;
    this.firstName = firstName;
    this.lastName = lastName;
    this.genre = genre;
  }

  public RegisterUserDTO emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * user email
   * @return emailAddress
  */
  @NotNull 
  @Schema(name = "emailAddress", description = "user email", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("emailAddress")
  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public RegisterUserDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * user password
   * @return password
  */
  @NotNull 
  @Schema(name = "password", description = "user password", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public RegisterUserDTO countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * country code
   * @return countryCode
  */
  @NotNull 
  @Schema(name = "countryCode", example = "237 for Cameroon country", description = "country code", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("countryCode")
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public RegisterUserDTO number(String number) {
    this.number = number;
    return this;
  }

  /**
   * phone number
   * @return number
  */
  @NotNull 
  @Schema(name = "number", example = "677891234", description = "phone number", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("number")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public RegisterUserDTO firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * User first name
   * @return firstName
  */
  @NotNull 
  @Schema(name = "firstName", description = "User first name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public RegisterUserDTO lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * User last name
   * @return lastName
  */
  @NotNull 
  @Schema(name = "lastName", description = "User last name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public RegisterUserDTO dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Get dateOfBirth
   * @return dateOfBirth
  */
  @Valid 
  @Schema(name = "dateOfBirth", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateOfBirth")
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public RegisterUserDTO genre(GenreDTO genre) {
    this.genre = genre;
    return this;
  }

  /**
   * Get genre
   * @return genre
  */
  @NotNull @Valid 
  @Schema(name = "genre", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("genre")
  public GenreDTO getGenre() {
    return genre;
  }

  public void setGenre(GenreDTO genre) {
    this.genre = genre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterUserDTO registerUserDTO = (RegisterUserDTO) o;
    return Objects.equals(this.emailAddress, registerUserDTO.emailAddress) &&
        Objects.equals(this.password, registerUserDTO.password) &&
        Objects.equals(this.countryCode, registerUserDTO.countryCode) &&
        Objects.equals(this.number, registerUserDTO.number) &&
        Objects.equals(this.firstName, registerUserDTO.firstName) &&
        Objects.equals(this.lastName, registerUserDTO.lastName) &&
        Objects.equals(this.dateOfBirth, registerUserDTO.dateOfBirth) &&
        Objects.equals(this.genre, registerUserDTO.genre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emailAddress, password, countryCode, number, firstName, lastName, dateOfBirth, genre);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterUserDTO {\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

