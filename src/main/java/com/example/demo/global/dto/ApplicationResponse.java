package com.example.demo.global.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationResponse<T> {

    private String code;
    private LocalDateTime timeStamp;
    private String message;
    private T data; // == body

    public static <T> ApplicationResponse<T> ok(){
        return (ApplicationResponse<T>) ApplicationResponse.builder()
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(null)
                .timeStamp(LocalDateTime.now())
                .message("성공")
                .build();
    }

    public static <T> ApplicationResponse<T> ok(T data){
        return (ApplicationResponse<T>) ApplicationResponse.builder()
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(data)
                .timeStamp(LocalDateTime.now())
                .message("성공")
                .build();
    }

}