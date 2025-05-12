package com.helius.otpReader;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/otp")
public class OtpReaderController {

    private final List<Message> messages = new ArrayList<>();

    @PostMapping("/save")
    public ResponseEntity<String> saveOtp(@RequestBody String otp) {

        String split[] = otp.split("~");
        switch (split.length) {

            case 1: messages.add(0, new Message(split[0]));
                    break;
            case 2: messages.add(0, new Message(split[0], split[1]));
                   break;
            case 3: messages.add(0, new Message(split[0], split[1], split[2]));
                   break;

        }

        if(messages.size() >=10)
            messages.remove(9);
        return ResponseEntity.ok("Otp saved successfully.");
    }
    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllOtps() {
        return ResponseEntity.ok(messages.stream().map(Message::toString).collect(Collectors.toList()));
    }


    @GetMapping("/view")
    public String home(Model model) {
        model.addAttribute("messages", messages);
        return "otpList.html";
    }


}
