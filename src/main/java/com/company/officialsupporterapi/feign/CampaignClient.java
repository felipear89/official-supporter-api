package com.company.officialsupporterapi.feign;

import com.company.officialsupporterapi.hystrix.CampaignClientFallback;
import com.company.officialsupporterapi.model.Campaign;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(name = "promotion-api", url = "http://localhost:8080", fallback = CampaignClientFallback.class)
public interface CampaignClient {

    @RequestMapping(method = GET, value = "/campaigns")
    List<Campaign> getCampaigns();

}
