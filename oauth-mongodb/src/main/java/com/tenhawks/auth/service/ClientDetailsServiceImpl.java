package com.tenhawks.auth.service;

import com.tenhawks.auth.domain.Client;
import com.tenhawks.auth.repository.ClientRepository;
import com.tenhawks.auth.security.MongoClientDetails;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

/**
 * Created by mukhtiar on 6/13/2018.
 */
public class ClientDetailsServiceImpl implements ClientDetailsService {

    private ClientRepository clientRepository;

    public ClientDetailsServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Client client =  clientRepository.findByClientId(clientId);
        if(client != null) {
            ClientDetails clientDetails = new MongoClientDetails(client);
            return clientDetails;
        } else {
            return null;
        }
    }
}
