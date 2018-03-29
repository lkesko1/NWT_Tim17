package ba.unsa.etf.nwtcinemamovies;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeRequests()
				.antMatchers("/**")
				.permitAll()
				.and()
				.csrf()
				.disable();
	}
}
