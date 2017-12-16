package com.company.officialsupporterapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@ResponseStatus(value = CONFLICT, reason = "Official supporter already exists")
public class OfficialSupporterAlreadyExistsException extends RuntimeException {}
