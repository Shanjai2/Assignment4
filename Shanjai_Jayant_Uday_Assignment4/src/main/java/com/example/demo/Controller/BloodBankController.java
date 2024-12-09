package com.example.demo.Controller;

import com.example.demo.*;
import com.example.demo.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BloodBankController {

    @Autowired
    private DonorRepo donorRepository;

    @Autowired
    private BloodBankRepo bloodBankRepository;

    @Autowired
    private BloodStockRepo bloodStockRepository;

    @PostMapping("/donor")
    public ResponseEntity<Donor> addOrUpdateDonor(@RequestBody Donor donor) {
        Donor savedDonor = donorRepository.save(donor);
        return ResponseEntity.ok(savedDonor);
    }

    @GetMapping("/donors")
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    @GetMapping("/donor/{id}")
    public ResponseEntity<Donor> getDonorById(@PathVariable String id) {
        return donorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/bloodbank")
    public ResponseEntity<BloodBank> addOrUpdateBloodBank(@RequestBody BloodBank bloodBank) {
        BloodBank savedBloodBank = bloodBankRepository.save(bloodBank);
        return ResponseEntity.ok(savedBloodBank);
    }

    @GetMapping("/bloodbanks")
    public List<BloodBank> getAllBloodBanks() {
        return bloodBankRepository.findAll();
    }

    @PostMapping("/bloodstock")
    public ResponseEntity<BloodStock> addOrUpdateBloodStock(@RequestBody BloodStock bloodStock) {
        BloodStock savedBloodStock = bloodStockRepository.save(bloodStock);
        return ResponseEntity.ok(savedBloodStock);
    }

    @GetMapping("/bloodstocks")
    public List<BloodStock> getAllBloodStocks() {
        return bloodStockRepository.findAll();
    }

    @GetMapping("/bloodstock/{bloodGroup}")
    public ResponseEntity<BloodStock> checkBloodAvailability(@PathVariable String bloodGroup) {
        BloodStock bloodStock = bloodStockRepository.findByBloodGroup(bloodGroup);
        if (bloodStock != null) {
            return ResponseEntity.ok(bloodStock);
        }
        return ResponseEntity.notFound().build();
    }
}