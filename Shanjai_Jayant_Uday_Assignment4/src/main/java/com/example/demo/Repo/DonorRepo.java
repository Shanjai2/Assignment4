package com.example.demo.Repo;

import com.example.demo.Donor;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DonorRepo extends MongoRepository<Donor, String> {
    List<Donor> findByBloodGroup(String bloodGroup);
}