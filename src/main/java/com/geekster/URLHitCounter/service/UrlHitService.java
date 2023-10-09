package com.geekster.URLHitCounter.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UrlHitService {

    private Map<String, Integer> hitCounts = new HashMap<>();

    public int getTotalHitCount() {
        return hitCounts.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getHitCountForUser(String username) {
        return hitCounts.getOrDefault(username, 0);
    }

    public void addVisitor(String username) {
        hitCounts.put(username, hitCounts.getOrDefault(username, 0) + 1);
    }

    public List<Map.Entry<String, Integer>> getAllVisitors() {
        List<Map.Entry<String, Integer>> visitorList = new ArrayList<>(hitCounts.entrySet());
        return visitorList;
    }

    public int getNumberOfVisitors() {
        return hitCounts.size();
    }

    public void incrementHitCountForUser(String username) {
        hitCounts.put(username, hitCounts.getOrDefault(username, 0) + 1);
    }

}
