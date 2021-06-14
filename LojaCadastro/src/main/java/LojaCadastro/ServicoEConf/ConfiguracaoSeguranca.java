package LojaCadastro.ServicoEConf;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import LojaCadastro.Repository.RepositoryCliente;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AutenticacaoServ AS;
	@Autowired
	private RepositoryCliente RC;
	@Autowired
	private ServicoToken TS;
	
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager () throws Exception {
		return super.authenticationManager();
	}
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(AS).passwordEncoder(new BCryptPasswordEncoder());
	 }
	 
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	        .antMatchers(HttpMethod.GET, "/produto").permitAll()
	        .antMatchers(HttpMethod.POST, "/produto").permitAll()
	        .antMatchers(HttpMethod.GET, "/usuario").permitAll()
	        .antMatchers(HttpMethod.POST, "/usuario").permitAll()
	        .antMatchers(HttpMethod.GET, "/endereco").permitAll()
	        .antMatchers(HttpMethod.POST, "/endereco").permitAll()
	        .antMatchers(HttpMethod.GET, "/pedido").permitAll()
	        .antMatchers(HttpMethod.POST, "/pedido").permitAll()
	        .antMatchers(HttpMethod.POST, "/autenticacao").permitAll()
	        .antMatchers(HttpMethod.POST, "/user").permitAll()
	        .antMatchers(HttpMethod.GET, "/user").permitAll()
	        .anyRequest().authenticated()
            .and().csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .addFilterBefore(new FiltroToken(TS, RC), UsernamePasswordAuthenticationFilter.class);
	 }
	 
	 @Override
	 public void configure(WebSecurity web) throws Exception {
	         web.ignoring().antMatchers
	                 ("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
	 }
}
	
