package pl.learning.flux.learningwebflux.service;

import org.springframework.stereotype.Service;
import pl.learning.flux.learningwebflux.dto.Response;
import pl.learning.flux.learningwebflux.util.Util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathService {

    public Response findSquare(int input) {
        return new Response(input * input);
    }

    public List<Response> multiplicationTable(int input) {
        List<Response> collect = IntStream.rangeClosed(1, 10)
                .peek(i -> Util.sleepSeconds(1))
                .peek(i -> System.out.println("Math service processing " + i))
                .mapToObj(i -> new Response(i * input))
                .collect(Collectors.toUnmodifiableList());
        return collect;
    }

}
