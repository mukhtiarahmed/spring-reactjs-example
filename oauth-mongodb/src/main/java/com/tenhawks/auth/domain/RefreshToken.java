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
@Document("refresh_token")
public class RefreshToken {

    @Id
    private String tokenId;

    private byte[] token;

    private byte[] authentication;


}
