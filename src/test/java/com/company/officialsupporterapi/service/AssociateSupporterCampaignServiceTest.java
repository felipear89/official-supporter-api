package com.company.officialsupporterapi.service;

import com.company.officialsupporterapi.feign.CampaignClient;
import com.company.officialsupporterapi.model.Campaign;
import com.company.officialsupporterapi.model.OfficialSupporter;
import com.company.officialsupporterapi.model.OfficialSupporterCampaigns;
import com.company.officialsupporterapi.repository.OfficialSupporterCampaignsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static com.company.officialsupporterapi.OfficialSupporterBuilder.officialSupporter;
import static integrationtest.CampaignsBuilder.genericCampaignTeamId;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AssociateSupporterCampaignServiceTest {

    @InjectMocks
    private AssociateSupporterCampaignService associateSupporterCampaignService;

    @Mock
    private CampaignClient campaignClient;

    @Mock
    private OfficialSupporterCampaignsRepository officialSupporterCampaignsRepository;

    @Test
    public void associate() {

        OfficialSupporter officialSupporter = officialSupporter();

        OfficialSupporterCampaigns officialSupporterCampaigns = getOfficialSupporterCampaigns(officialSupporter);

        Campaign campaign = genericCampaignTeamId("spfc");

        when(campaignClient.getCampaignsByTeamId(any())).thenReturn(asList(campaign));

        when(officialSupporterCampaignsRepository.findByOfficialSupporterId(any())).thenReturn(Optional.of(officialSupporterCampaigns));
        when(officialSupporterCampaignsRepository.save(any())).thenReturn(officialSupporterCampaigns);

        OfficialSupporterCampaigns associate = associateSupporterCampaignService.associate(officialSupporter);

        assertEquals(associate.getOfficialSupporterId(), officialSupporterCampaigns.getOfficialSupporterId());
        assertEquals(1, associate.getCampaigns().size());
    }

    private OfficialSupporterCampaigns getOfficialSupporterCampaigns(OfficialSupporter officialSupporter) {
        OfficialSupporterCampaigns officialSupporterCampaigns = new OfficialSupporterCampaigns();
        officialSupporterCampaigns.setId("1");
        officialSupporterCampaigns.setCampaigns(new ArrayList<>());
        officialSupporterCampaigns.setOfficialSupporterId(officialSupporter.getId());
        return officialSupporterCampaigns;
    }
}