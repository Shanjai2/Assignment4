package com.example.demo.Repo;

import com.example.demo.BloodStock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BloodStockRepo extends MongoRepository<BloodStock, String> {
    BloodStock findByBloodGroup(String bloodGroup);
}