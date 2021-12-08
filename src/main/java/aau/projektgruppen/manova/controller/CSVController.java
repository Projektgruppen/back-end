package aau.projektgruppen.manova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import aau.projektgruppen.manova.service.CSVService;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/v1/logs")
public class CSVController {

    @Autowired
    CSVService fileService;


    @GetMapping("{sessionId}/download")
    public ResponseEntity<Resource> getFile(@PathVariable Long sessionId) {
        String filename = String.format("log %d.csv", sessionId);
        InputStreamResource file = new InputStreamResource(fileService.load(sessionId));
        try {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                    .contentType(MediaType.parseMediaType("application/csv"))
                    .body(file);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }
}