package net.yorksoultions.echo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/")
public class IndexController {
    AuthService service;
    public IndexController(AuthService service){
       this.service = service;
    }
    @GetMapping
    public String echo(@RequestParam UUID token, @RequestParam String message){
        if(this.service.check_token(token)){
            return message;
        } else {
            throw  new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}
