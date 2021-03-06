package com.company.officialsupporterapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(value = NOT_FOUND, reason = "Official supporter not found")
public class OfficialSupporterNotFoundException extends RuntimeException {
}
