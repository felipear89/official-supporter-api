package com.company.officialsupporterapi.repository;

import com.company.officialsupporterapi.model.OfficialSupporter;
import com.company.officialsupporterapi.model.OfficialSupporterCampaigns;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OfficialSupporterCampaignsRepository extends MongoRepository<OfficialSupporterCampaigns, String> {

    Optional<OfficialSupporterCampaigns> findByOfficialSupporterId(String officialSupporter);

}
