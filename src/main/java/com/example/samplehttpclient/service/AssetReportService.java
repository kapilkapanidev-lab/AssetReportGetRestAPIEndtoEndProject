package com.example.samplehttpclient.service;

import com.example.samplehttpclient.dto.AssetReportDto;
import com.example.samplehttpclient.exception.AssetReportNotFoundException;
import com.example.samplehttpclient.exception.ExternalAPIException;
import com.example.samplehttpclient.exception.ServerError;
import com.example.samplehttpclient.model.AssetReport;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

@Service
public class AssetReportService {
    public AssetReportDto getAssetReportExternally(Long assetId) {
        try {
            String url = "https://jsonplaceholder.typicode.com/posts/";
            AssetReportDto assetReportDto = null;
            RestTemplate restTemplate = new RestTemplate();
            AssetReport assetReport = restTemplate.getForObject(url + assetId, AssetReport.class);
            ObjectMapper objectMapper = new ObjectMapper();
            assetReportDto = objectMapper.convertValue(assetReport, AssetReportDto.class);
//            return assetReportDto;
            throw new AssetReportNotFoundException("just not found", new RuntimeException());
        } catch (HttpClientErrorException.NotFound ex) {
            throw new AssetReportNotFoundException("Asset not found " + assetId, ex);
        } catch (HttpClientErrorException ex) {
            throw new ExternalAPIException("API Error", ex);
        } catch (HttpServerErrorException ex) {
            throw new ServerError("Server error", ex);
        }
    }
}
