package net.yorksoultions.echo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@Service
public class AuthService {
    RestTemplate client;
    @Value("${net.yorksolutions.authUrl}")
    String authUrl;

    public AuthService(){
        this.client = new RestTemplate();
    }
    public boolean check_token(UUID token){
        var url = String.format("%s/checkAuth?token=%s", this.authUrl, token) ;
        System.out.println(url);
        try {
            ResponseEntity<Void> response = this.client.getForEntity(url, Void.class);
            if (OK.equals(response.getStatusCode())) {
                return true;
            }
        } catch (Exception e){
            return false;
        }
        return false;
    }
}
