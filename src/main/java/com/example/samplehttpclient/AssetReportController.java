package com.example.samplehttpclient;

import com.example.samplehttpclient.dto.AssetReportDto;
import com.example.samplehttpclient.service.AssetReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assetReport")
public class AssetReportController {

    @Autowired
    AssetReportService assetReportService;

    @GetMapping("/{assetId}")
    public ResponseEntity<AssetReportDto> getAssetReport(@PathVariable("assetId") Long assetId) {
            AssetReportDto assetReport = assetReportService.getAssetReportExternally(assetId);
            return ResponseEntity.status(HttpStatus.OK).body(assetReport);


    }
}
