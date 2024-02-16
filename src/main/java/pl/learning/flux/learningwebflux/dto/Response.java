package pl.learning.flux.learningwebflux.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public final class Response {

    private final Date date = new Date();
    private final int result;

    public Response(int result) {
        this.result = result;
    }

}
