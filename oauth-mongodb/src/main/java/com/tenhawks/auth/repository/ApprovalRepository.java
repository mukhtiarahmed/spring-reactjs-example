package com.tenhawks.auth.repository;

import com.tenhawks.auth.domain.Approval;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

/**
 * Created by Mukhtiar on 5/23/2018.
 */
public interface ApprovalRepository extends MongoRepository<Approval, String> {
}
