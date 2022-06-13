package ru.otus.spring.cli;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import ru.otus.spring.service.PirateService;
import ru.otus.spring.service.PirateShipGenerator;

import java.util.List;
import java.util.concurrent.Callable;

@Command(
    name = "pirate", mixinStandardHelpOptions = true,
    description = "Pirate name generation",
    subcommands = PiratesCommand.GenerateShip.class
)
@Component
@RequiredArgsConstructor
public class PiratesCommand implements Callable<Integer> {

    private final PirateService pirateService;

    @Override
    public Integer call() throws Exception {
        System.out.println(pirateService.randomPirate());
        return 0;
    }

    @RequiredArgsConstructor
    @Component
    @Command(
        name = "build-ship", mixinStandardHelpOptions = true,
        description = "Build pirate ship with parameters"
    )
    static class GenerateShip implements Callable<Integer> {

        private final PirateShipGenerator pirateShipGenerator;

        @Parameters(index = "0", description = "Name of the ship")
        private String shipName;

        @Parameters(index = "1", description = "Length of the ship")
        private int shipLength;

        @Override
        public Integer call() {
            System.out.println("paramters: " + shipName + ", " + shipLength);

            System.out.println(pirateShipGenerator.generateShip(shipName, shipLength));
            return 0;
        }
    }
}

