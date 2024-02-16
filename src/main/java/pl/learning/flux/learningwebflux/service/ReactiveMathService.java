package pl.learning.flux.learningwebflux.service;

import org.springframework.stereotype.Service;
import pl.learning.flux.learningwebflux.dto.Response;
import pl.learning.flux.learningwebflux.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ReactiveMathService {
    public Mono<Response> findSquare(int input) {
        return Mono.fromSupplier(() -> new Response(input * input));
    }

    public Flux<Response> multiplicationTable(int input) {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                //.doOnNext(i -> Util.sleepSeconds(1))
                .doOnNext(i -> System.out.println("Reactive Math service processing " + i))
                .map(i -> new Response(i * input));

    }
}
