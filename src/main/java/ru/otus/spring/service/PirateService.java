package ru.otus.spring.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PirateService {

    private final List<String> pirates = List.of("Blackbeard", "Henry Morgan", "Sir Francis Drake");

    public String randomPirate() {
        return pirates.get(new Random().nextInt(pirates.size()));
    }
}
