package br.com.jayatech.currencyconverter.exception;

import java.util.Collections;
import java.util.List;

public class ResponseError {
    private Integer statusCode;
    private List<String> errors;

    public Integer getStatusCode() {
        return statusCode;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public ResponseError(Integer statusCode, List<String> errors){
        this.statusCode = statusCode;
        this.errors = errors;
    }

    public ResponseError(Integer statusCode, String error){
        this.statusCode = statusCode;
        this.errors = Collections.singletonList(error);
    }
}
