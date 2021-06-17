package pl.pjatk.sampleMicroservice.rentalService.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException ex) {

        switch (ex.getStatusCode()) {
            case NOT_FOUND:
                return new ResponseEntity<>("Not Found: 404", NOT_FOUND);
            case BAD_REQUEST:
                return new ResponseEntity<>("Bad Request: 400", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<String> handleHttpServerException(HttpServerErrorException ex) {

        if (ex.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
            return new ResponseEntity<>("Bad GateWay: 502", HttpStatus.BAD_GATEWAY);
        }
        if (ex.getStatusCode().equals(HttpStatus.GATEWAY_TIMEOUT)) {
            return new ResponseEntity<>("GateWay TimeOut: 504", HttpStatus.GATEWAY_TIMEOUT);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
