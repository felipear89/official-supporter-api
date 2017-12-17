package com.company.officialsupporterapi.controller;

import com.company.officialsupporterapi.exception.OfficialSupporterAlreadyExistsException;
import com.company.officialsupporterapi.exception.OfficialSupporterNotFoundException;
import com.company.officialsupporterapi.model.OfficialSupporter;
import com.company.officialsupporterapi.model.OfficialSupporterCampaigns;
import com.company.officialsupporterapi.repository.OfficialSupporterCampaignsRepository;
import com.company.officialsupporterapi.repository.OfficialSupporterRepository;
import com.company.officialsupporterapi.service.AssociateSupporterCampaignService;
import com.company.officialsupporterapi.service.OfficialSupporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/officialSupporters", produces = APPLICATION_JSON_VALUE)
public class OfficialSupporterController {

    @Autowired
    private OfficialSupporterService officialSupporterService;

    @Autowired
    private OfficialSupporterRepository supporterRepository;

    @Autowired
    private AssociateSupporterCampaignService associateSupporterCampaignService;

    @Autowired
    private OfficialSupporterCampaignsRepository officialSupporterCampaignsRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OfficialSupporter create(@Valid @RequestBody OfficialSupporter officialSupporter) throws OfficialSupporterAlreadyExistsException {
        return officialSupporterService.save(officialSupporter);
    }

    @GetMapping("/{id}")
    public OfficialSupporter show(@PathVariable String id) {
        return supporterRepository.findById(id).orElseThrow(OfficialSupporterNotFoundException::new);
    }

    @GetMapping
    public List<OfficialSupporter> list() {
        return supporterRepository.findAll();
    }

    @RequestMapping(method = POST, path = "/{officialSupporterId}/associate")
    public OfficialSupporterCampaigns associate(@PathVariable("officialSupporterId") String officialSupporterId) {
        Optional<OfficialSupporter> supporter = supporterRepository.findById(officialSupporterId);

        OfficialSupporter officialSupporter = supporter.orElseThrow(OfficialSupporterNotFoundException::new);

        return associateSupporterCampaignService.associate(officialSupporter);
    }

    @RequestMapping(method = GET, path = "/{officialSupporterId}/associate")
    public OfficialSupporterCampaigns getAssociate(@PathVariable("officialSupporterId") String officialSupporterId) {
        return officialSupporterCampaignsRepository.findByOfficialSupporterId(officialSupporterId)
                .orElseThrow(OfficialSupporterNotFoundException::new);
    }

}
