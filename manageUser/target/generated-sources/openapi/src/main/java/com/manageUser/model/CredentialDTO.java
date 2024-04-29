package com.manageUser.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CredentialDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-29T15:07:47.730735998+01:00[Africa/Douala]")
public class CredentialDTO {

  private String username;

  private String password;

  public CredentialDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * employee firstname
   * @return username
  */
  
  @Schema(name = "username", description = "employee firstname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public CredentialDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * employee lastname
   * @return password
  */
  
  @Schema(name = "password", description = "employee lastname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CredentialDTO credentialDTO = (CredentialDTO) o;
    return Objects.equals(this.username, credentialDTO.username) &&
        Objects.equals(this.password, credentialDTO.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CredentialDTO {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

