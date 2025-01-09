package exam.kea.dk.deletelater.controller;

import exam.kea.dk.deletelater.repository.GreetingRepository;
import exam.kea.dk.deletelater.model.Greeting;
import exam.kea.dk.deletelater.service.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingRepository greetingRepository;
    private final GreetingService greetingService;

    public GreetingController(GreetingRepository greetingRepository, GreetingService greetingService) {
        this.greetingRepository = greetingRepository;
        this.greetingService = greetingService;
    }

    // added comment
    // BIRGWE XINNXBWR
    @GetMapping("/")
    public ResponseEntity<Greeting> greeting() {
        Greeting greeting = new Greeting("Hej fra serveren");
        greetingRepository.save(greeting);
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
