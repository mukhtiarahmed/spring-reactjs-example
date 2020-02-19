package com.tenhawks.auth.domain;

import lombok.Data;

import org.bson.ByteBufNIO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author Mukhtiar Ahmed
 */
@Document("access_token")
@Data
public class AccessToken {

    @Id
    private String tokenId;

    private byte[] token;

    private String authenticationId;

    private String username;

    private String clientId;

    private byte[] authentication;

    private String refreshToken;

}
