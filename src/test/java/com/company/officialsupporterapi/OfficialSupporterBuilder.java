package com.company.officialsupporterapi;

import com.company.officialsupporterapi.model.OfficialSupporter;

public class OfficialSupporterBuilder {
    public static OfficialSupporter officialSupporter() {
        OfficialSupporter officialSupporter = new OfficialSupporter();
        officialSupporter.setEmail("test@fake.com");
        officialSupporter.setName("James");
        officialSupporter.setTeamId("spfc");
        return officialSupporter;
    }
}
