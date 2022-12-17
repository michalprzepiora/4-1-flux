package co.kodilla.flux.controller;

import co.kodilla.flux.model.BookDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FluxBookController {

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<BookDto> getBooks(){
        BookDto b1 = new BookDto("Title1", "Author1", 2000);
        BookDto b2 = new BookDto("Title2", "Author2", 2000);
        BookDto b3 = new BookDto("Title3", "Author3", 2000);
        BookDto b4 = new BookDto("Title4", "Author4", 2000);
        return Flux.just(b1,b2,b3,b4).delayElements(Duration.ofSeconds(1)).log();
    }
}
