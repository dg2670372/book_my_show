package com.example.book_my_show.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SeatUnavailableException extends RuntimeException{

    public SeatUnavailableException(String message)
    {
        super(message);
    }
}