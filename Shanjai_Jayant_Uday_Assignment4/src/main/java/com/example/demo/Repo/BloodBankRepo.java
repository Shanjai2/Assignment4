package com.example.demo.Repo;

import com.example.demo.BloodBank;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BloodBankRepo extends MongoRepository<BloodBank, String> {
	
}