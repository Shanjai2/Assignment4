package com.example.demo.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class homeController {
	 @GetMapping
	    public String home() {
	        return "BloodBank test";
	    }
}
