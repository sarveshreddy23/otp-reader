package com.helius.otpReader;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/otp")
public class OtpReaderController {

    private final List<String> otpList = new ArrayList<>();

    @PostMapping("/save")
    public ResponseEntity<String> saveOtp(@RequestBody String otp) {
        otpList.add(0, otp);
        if(otpList.size() >=10)
            otpList.remove(9);
        return ResponseEntity.ok("Otp saved successfully.");
    }
    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllOtps() {
        return ResponseEntity.ok(otpList);
    }


}
