package com.tenhawks.auth;

import com.tenhawks.auth.domain.Client;
import com.tenhawks.auth.domain.Role;
import com.tenhawks.auth.domain.User;
import com.tenhawks.auth.repository.ClientRepository;
import com.tenhawks.auth.repository.RoleRepository;
import com.tenhawks.auth.repository.UserRepository;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultAuthenticationKeyGenerator;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


/**
 * @author Mukhtiar
 */
@SpringBootApplication
@Configuration
public class AuthApplication {

	private static final Logger log = LoggerFactory.getLogger(AuthApplication.class);
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args)  throws Exception {

		SpringApplication.run(AuthApplication.class, args);
	}

	@Bean
	public AuthenticationKeyGenerator getAuthenticationKeyGenerator() {
		return new DefaultAuthenticationKeyGenerator();
	}


    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {
        List<String> mappingFiles = Arrays.asList(
                "dozer-configration-mapping.xml"
        );

        DozerBeanMapper dozerBean = new DozerBeanMapper();
        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

	@Bean
	InitializingBean sendDatabase() {


		return () -> {

			Client client = clientRepository.findByClientId("cffe3990-6f0e-11e8-b750-4d8614c940ff");
			if (client == null) {
				client = new Client();
                client.setAccessTokenValiditySeconds(2592000);
                client.setRefreshTokenValiditySeconds(2592000 * 30);
                client.setClientId("cffe3990-6f0e-11e8-b750-4d8614c940ff");
                client.setClientSecret("$2a$12$.5qlSA.5Gjp9.TRlEflnXukLlYUz/eNRhLgFKubk6PIoL8GM7GzLu");
                client.getScope().add("trust");
                client.getAuthorizedGrantTypes().add("password");
                client.getAuthorizedGrantTypes().add("refresh_token");
                clientRepository.save(client);


                Role role = new Role();
                role.setId(UUID.randomUUID().toString());
                role.setRoleName("ROLE_USER");
                roleRepository.save(role);

                role = new Role();
                role.setId(UUID.randomUUID().toString());
                role.setRoleName("ROLE_ADMIN");
                roleRepository.save(role);

                role = new Role();
                role.setId(UUID.randomUUID().toString());
                role.setRoleName("ROLE_SUPER_ADMIN");
                roleRepository.save(role);

                User user = new User();
                role.setId(UUID.randomUUID().toString());
                user.setRoles(Arrays.asList(role.getRoleName()));
                user.setEmailAddress("mukhtiar.ahmed@gmail.com");
                user.setActive(true);
                user.setFullName("Mukhtiar Ahmed");
                user.setUserName("ahmed");
                user.setPhoneNumber("+923100000000");
                // password is  `secert`
                user.setPassword("$2a$12$2kV1gT4c3XM.Gl1jHPoLYO/V7Pg.A1KnlUlZBrf5rnDXjYNLgc6N6");
                userRepository.save(user);
                user = userRepository.findByUserName("ahmed");
                user.getRoles();
            }
		};
	}

}
