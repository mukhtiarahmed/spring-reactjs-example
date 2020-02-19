package com.tenhawks.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.ByteBuf;
import org.bson.ByteBufNIO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.nio.ByteBuffer;

/**
 * @author Mukhtiar Ahmed
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("client_token")
public class ClientToken {

    @Id
    private String tokenId;

    private byte[] token;
    private String authenticationId;

    private String username;

    private String clientId;

}
