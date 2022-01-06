package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
        .withClient("testClientId")
        .secret("{noop}testSecret")
        .redirectUris("http://localhost:8081/oauth2/callback")
        .authorizedGrantTypes("authorization_code")
//        .authorizedGrantTypes("authorization_code", "implicit")
        .scopes("read", "write")
        .accessTokenValiditySeconds(30000);
  }
}
