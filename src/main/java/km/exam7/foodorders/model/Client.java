package km.exam7.foodorders.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "clients")
public class Client implements UserDetails {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String email;
    private String notEncodedPass;
    private String password;

    public static Client make(String name, String email, String pass) {
        Client c = new Client();
        c.setName(name);
        c.setEmail(email);
        c.setNotEncodedPass(pass);
        c.setPassword(new BCryptPasswordEncoder().encode(c.getNotEncodedPass()));
        return c;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FULL"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
