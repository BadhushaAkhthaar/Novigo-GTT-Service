package com.novigo.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.Jwt;

import com.sap.cloud.security.xsuaa.XsuaaServiceConfiguration;
import com.sap.cloud.security.xsuaa.extractor.IasXsuaaExchangeBroker;
import com.sap.cloud.security.xsuaa.token.TokenAuthenticationConverter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfigService extends WebSecurityConfigurerAdapter
{
	@Autowired
	XsuaaServiceConfiguration xsuaaServiceConfiguration;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
//		http.sessionManagement()
//			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//			.and()
////			.authorizeRequests()	
////			.antMatchers("/*").authenticated()
////			.antMatchers("/local/*").permitAll()
////			.antMatchers("/home**").hasAuthority("Display")
//			.anyRequest().permitAll()
////			.and()
////			.oauth2ResourceServer()
////			.bearerTokenResolver(new IasXsuaaExchangeBroker(xsuaaServiceConfiguration))
////			.jwt()
////			.jwtAuthenticationConverter(getJwtAuthenticationConverter());
	}
	Converter<Jwt, AbstractAuthenticationToken> getJwtAuthenticationConverter(){
		TokenAuthenticationConverter converter = new TokenAuthenticationConverter(xsuaaServiceConfiguration);
		converter.setLocalScopeAsAuthorities(true);
		return converter;
	}
}