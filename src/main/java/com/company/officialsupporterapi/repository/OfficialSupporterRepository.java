package com.company.officialsupporterapi.repository;

import com.company.officialsupporterapi.model.OfficialSupporter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OfficialSupporterRepository extends MongoRepository<OfficialSupporter, String> {

    Optional<OfficialSupporter> findByEmail(String email);

    Optional<OfficialSupporter> findById(String id);

}
