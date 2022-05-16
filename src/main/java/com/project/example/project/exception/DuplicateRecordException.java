package com.project.example.project.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)//Exception - какъв статус Код да връща - за еднакви имена
public class DuplicateRecordException extends RuntimeException {

    public DuplicateRecordException(String message) { //cntrl+o - > кой методи/Конструктори да ползваме
        super(message);
    }

    public DuplicateRecordException(String message, Throwable cause) {
        super(message, cause);
    }
}
