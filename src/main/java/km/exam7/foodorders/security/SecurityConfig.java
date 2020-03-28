package km.exam7.foodorders.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/orders/**").fullyAuthenticated();

        http.authorizeRequests()
                .anyRequest()
                .permitAll();

        // Настраиваем хранение сессий. Не храним сессию.
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Используем авторизацию по механизму Http Basic.
        // Данные пользователя передаются через заголовок запроса
        http.httpBasic();

        // Так как мы авторизуемся через заголовок запроса, то
        // форма входа на сайт и выхода с него нам тоже не нужны.
        http.formLogin().disable().logout().disable();

        // Так как у нас REST сервис, нам не нужна защита от CSRF
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
