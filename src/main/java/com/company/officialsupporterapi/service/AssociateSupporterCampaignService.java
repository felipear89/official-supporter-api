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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

@Service
public class AssociateSupporterCampaignService {

    private static final Logger log = LoggerFactory.getLogger(AssociateSupporterCampaignService.class);

    @Autowired
    private CampaignClient campaignClient;

    @Autowired
    private OfficialSupporterCampaignsRepository officialSupporterCampaignsRepository;

    public OfficialSupporterCampaigns associate(OfficialSupporter officialSupporter) {

        List<Campaign> campaigns = campaignClient.getCampaignsByTeamId(officialSupporter.getTeamId());

        Optional<OfficialSupporterCampaigns> optOfficialSupporterCampaigns = officialSupporterCampaignsRepository.
                findByOfficialSupporterId(officialSupporter.getId());

        OfficialSupporterCampaigns osc = optOfficialSupporterCampaigns.orElseGet(() -> {
            OfficialSupporterCampaigns newSupporterCampaign = new OfficialSupporterCampaigns();
            newSupporterCampaign.setOfficialSupporterId(officialSupporter.getId());
            newSupporterCampaign.setCampaigns(newArrayList());
            return newSupporterCampaign;
        });

        List<String> ids = campaigns.stream().map(campaign -> campaign.getId()).collect(toList());

        HashSet<String> campaignsToAdd = new HashSet<>();
        campaignsToAdd.addAll(osc.getCampaigns());
        campaignsToAdd.addAll(ids);
        osc.setCampaigns(newArrayList(campaignsToAdd));

        return officialSupporterCampaignsRepository.save(osc);

    }
}
