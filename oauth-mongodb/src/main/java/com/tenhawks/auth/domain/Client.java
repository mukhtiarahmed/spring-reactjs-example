package com.tenhawks.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mukhtiar Ahmed
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("client")
public class Client {

    @Id
    protected String clientId;
    protected String clientSecret;
    @Indexed(unique = true)
    protected String clientName;

    protected Set<String> scope = new HashSet<String>();
    protected Set<String> resourceIds = new HashSet<String>();
    protected Set<String> authorizedGrantTypes = new HashSet<String>();
    protected Set<String> registeredRedirectUris  = new HashSet<String>();
    // JSON GrantedAuthority
    protected List<String> authorities;
    protected Integer accessTokenValiditySeconds = 21600;
    protected Integer refreshTokenValiditySeconds = 2592000;
    // JSON Map<String, Object>
    protected String additionalInformation;
    protected Set<String> autoApproveScopes;




}
