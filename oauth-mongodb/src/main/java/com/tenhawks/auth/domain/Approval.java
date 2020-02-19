package com.tenhawks.auth.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.oauth2.provider.approval.Approval.ApprovalStatus;

import java.util.Date;
import java.util.UUID;

/**
 * @author Mukhtiar Ahmed
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("approval")
public class Approval {

    @Id
    private String id;

    private String userId;

    private String clientId;

    private String scope;

    private ApprovalStatus status;

    private Date expiresAt;

    private Date lastUpdatedAt;

}
