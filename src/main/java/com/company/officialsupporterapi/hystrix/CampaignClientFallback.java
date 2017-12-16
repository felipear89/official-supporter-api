package com.company.officialsupporterapi.hystrix;

import com.company.officialsupporterapi.feign.CampaignClient;
import com.company.officialsupporterapi.model.Campaign;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

@Component
public class CampaignClientFallback implements CampaignClient {

    @Override
    public List<Campaign> getCampaigns() {
        return emptyList();
    }

}
