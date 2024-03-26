@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF for simplicity (consider enabling for production)
                .authorizeRequests()
                .antMatchers("/api/credentials/**").authenticated() // Require authentication for all credential endpoints
                .and()
                .httpBasic(); // Use HTTP Basic authentication for master password
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication() // Use in-memory authentication for simplicity (consider using a database for production)
                .passwordEncoder(passwordEncoder()) // Use a password encoder for secure storage
                .withUser("user") // Replace "user" with desired username
                .password(passwordEncoder().encode("masterPassword")) // Replace "masterPassword" with actual master password
                .roles("USER");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
