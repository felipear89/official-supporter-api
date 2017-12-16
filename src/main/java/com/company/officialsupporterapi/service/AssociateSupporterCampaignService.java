package com.company.officialsupporterapi.service;

import com.company.officialsupporterapi.feign.CampaignClient;
import com.company.officialsupporterapi.model.Campaign;
import com.company.officialsupporterapi.model.OfficialSupporter;
import com.company.officialsupporterapi.model.OfficialSupporterCampaigns;
import com.company.officialsupporterapi.repository.OfficialSupporterCampaignsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociateSupporterCampaignService {

    private static final Logger log = LoggerFactory.getLogger(AssociateSupporterCampaignService.class);

    @Autowired
    private CampaignClient campaignClient;

    @Autowired
    private OfficialSupporterCampaignsRepository officialSupporterCampaignsRepository;

    public void associate(OfficialSupporter officialSupporter) {

        List<Campaign> campaigns = campaignClient.getCampaignsByTeamId(officialSupporter.getTeamId());

        Optional<OfficialSupporterCampaigns> officialSupporterCampaigns = officialSupporterCampaignsRepository.
                findByOfficialSupporterId(officialSupporter.getId());

        log.info("#############");
        log.info("{}", officialSupporterCampaigns);
        log.info("{}", campaigns);
    }
}
