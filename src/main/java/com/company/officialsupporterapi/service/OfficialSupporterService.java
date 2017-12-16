package com.company.officialsupporterapi.service;

import com.company.officialsupporterapi.exception.OfficialSupporterAlreadyExistsException;
import com.company.officialsupporterapi.model.OfficialSupporter;
import com.company.officialsupporterapi.repository.OfficialSupporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfficialSupporterService {

    @Autowired
    private OfficialSupporterRepository supporterRepository;

    @Autowired
    private AssociateSupporterCampaignService associateSupporterCampaignService;

    public OfficialSupporter save(OfficialSupporter officialSupporter) {

        checkConflict(officialSupporter);

        OfficialSupporter savedOfficialSupporter = supporterRepository.save(officialSupporter);

        return savedOfficialSupporter;
    }

    private void checkConflict(OfficialSupporter officialSupporter) {
        Optional<OfficialSupporter> optionalOfficialSupporter = supporterRepository.findByEmail(officialSupporter.getEmail());

        optionalOfficialSupporter.ifPresent(s -> {
            throw new OfficialSupporterAlreadyExistsException();
        });
    }
}
