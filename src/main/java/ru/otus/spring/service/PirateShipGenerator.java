package ru.otus.spring.service;

import org.springframework.stereotype.Service;

import static java.lang.Math.max;

@Service
public class PirateShipGenerator {

    public String generateShip(String shipName, int shipLength) {
        int maxLength = max(shipName.length(), shipLength);
        var spaces = " ".repeat(maxLength);
        var underscores = "_".repeat(maxLength);
        var paddedShipName = shipName + "_".repeat(maxLength - shipName.length());
        return "" +
            "    " + spaces + "  _~\n" +
            "    " + spaces + " )_)_~\n" +
            "    " + spaces + " )_))_)\n" +
            "  __" + underscores + " _!__!_\n" +
            "  \\" + paddedShipName + "______t/";
    }
}
