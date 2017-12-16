package com.company.officialsupporterapi.controller;

import com.company.officialsupporterapi.exception.OfficialSupporterAlreadyExistsException;
import com.company.officialsupporterapi.model.OfficialSupporter;
import com.company.officialsupporterapi.service.OfficialSupporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/officialSupporters", produces = APPLICATION_JSON_VALUE)
public class OfficialSupporterController {

    @Autowired
    private OfficialSupporterService officialSupporterService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OfficialSupporter create(@Valid @RequestBody OfficialSupporter officialSupporter) throws OfficialSupporterAlreadyExistsException {
        return officialSupporterService.save(officialSupporter);
    }



}
