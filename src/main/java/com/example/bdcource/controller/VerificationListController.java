package com.example.bdcource.controller;

import com.example.bdcource.dto.VerificationListDto;
import com.example.bdcource.mapping.VerificationListMapping;
import com.example.bdcource.service.VerificationListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bdcource/verification")
public class VerificationListController {
    @Autowired
    private VerificationListService verificationListService;
    @Autowired
    private VerificationListMapping verificationListMapping;

    @PostMapping("/addverification")
    public ResponseEntity<Integer> addVerification(@RequestBody VerificationListDto verificationListDto) {
        verificationListService.addVerification(verificationListDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/takeverification")
    public VerificationListDto takeVerificationById(@RequestParam("id") Integer id) {
        return verificationListService.takeVerification(id);
    }

    @GetMapping("/takedocumenttype")
    public String takeDocumentType(@RequestParam("id")int verificationId){
        return verificationListService.takeDocumentType(verificationId);
    }
    @GetMapping("/takeallverification")
    public List<VerificationListDto> takeAllVerifications() {
        return verificationListService.takeAllVerifications();
    }

    @DeleteMapping("/rejectverification")
    public ResponseEntity<Integer> rejectVerification(@RequestParam("id") Integer id) {
        verificationListService.rejectVerification(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
