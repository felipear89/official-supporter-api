package com.company.officialsupporterapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class OfficialSupporterCampaigns {

    @Id
    private String id;

    private String officialSupporterId;

    private List<String> campaigns;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOfficialSupporterId() {
        return officialSupporterId;
    }

    public void setOfficialSupporterId(String officialSupporterId) {
        this.officialSupporterId = officialSupporterId;
    }

    public List<String> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<String> campaigns) {
        this.campaigns = campaigns;
    }
}
