package com.tenhawks.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Mukhtiar Ahmed
 */
@Data
@Document("user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User  {

  private static final long serialVersionUID = -3392490659474682931L;

  @Id
  private String userId;

  @Indexed(unique = true)
  @NotBlank
  private String userName;

  @NotBlank
  private String emailAddress;

  private String fullName;


  private String profileImage;

  @NotBlank
  private String password;

  private Boolean active = Boolean.FALSE;

  private String phoneNumber;

  private List<String> roles =new ArrayList<>();

}
