package com.tenhawks.auth.repository;

import com.tenhawks.auth.domain.RefreshToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RefreshTokenRepository extends MongoRepository<RefreshToken, String> {



    RefreshToken findByTokenId(String tokenId);

}
