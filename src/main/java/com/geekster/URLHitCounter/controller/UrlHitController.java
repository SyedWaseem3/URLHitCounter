package com.geekster.URLHitCounter.controller;

import com.geekster.URLHitCounter.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/visitor-count-app")
public class UrlHitController {
    @Autowired
    UrlHitService urlHitService;

    @GetMapping("/count")
    public Map<String, Integer> getTotalHitCount() {
        int totalCount = urlHitService.getTotalHitCount();
        Map<String, Integer> response = new HashMap<>();
        response.put("visitors", totalCount);
        return response;
    }

    @GetMapping("/username/{username}/count")
    public Map<String, Object> getHitCountForUser(@PathVariable String username) {
        int userHitCount = urlHitService.getHitCountForUser(username);
        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("hitcount", userHitCount);
        return response;
    }

    @PostMapping("/visitor")
    public void addVisitor(@RequestParam String username) {
        urlHitService.addVisitor(username);
    }

    @GetMapping("/visitors")
    public List<Map.Entry<String, Integer>> getAllVisitors() {
        return urlHitService.getAllVisitors();
    }

    @GetMapping("/visitor/count")
    public int getNumberOfVisitors() {
        return urlHitService.getNumberOfVisitors();
    }

    @PutMapping("/count_update/username/{username}")
    public void incrementHitCountForUser(@PathVariable String username) {
        urlHitService.incrementHitCountForUser(username);
    }
}
