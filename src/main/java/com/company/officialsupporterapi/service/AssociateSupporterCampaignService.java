package com.company.officialsupporterapi.service;

import com.company.officialsupporterapi.feign.CampaignClient;
import com.company.officialsupporterapi.model.Campaign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociateSupporterCampaignService {

    private static final Logger log = LoggerFactory.getLogger(AssociateSupporterCampaignService.class);

    @Autowired
    private CampaignClient campaignClient;

    public void getCampaigns() {
        List<Campaign> campaigns = campaignClient.getCampaigns();
        log.info("{}", campaigns);
    }
}
