package ru.otus.spring.service;

import org.springframework.stereotype.Service;

@Service
public class PirateShipGenerator {

    public String generateShip() {
        return "" +
            "      _~\n" +
            "     )_)_~\n" +
            "     )_))_)\n" +
            "  ____!__!_\n" +
            "  \\______t/";
    }
}
