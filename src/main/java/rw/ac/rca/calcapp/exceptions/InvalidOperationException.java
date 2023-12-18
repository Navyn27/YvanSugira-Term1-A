package rw.ac.rca.calcapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
class InvalidOperandException extends RuntimeException {
    public InvalidOperandException(String message) {
        super(message);
    }
}