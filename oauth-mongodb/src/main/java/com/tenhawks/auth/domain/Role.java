package com.tenhawks.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * @author Mukhtiar Ahmed
 */
@Data
@Document("role")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role  {
  private static final long serialVersionUID = -1077836392559104967L;

  @Id
  private String id;
  @Indexed(unique = true)
  private String roleName;
}
