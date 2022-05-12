package ru.otus.spring.cli;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import ru.otus.spring.service.PirateService;
import ru.otus.spring.service.PirateShipGenerator;

import java.util.concurrent.Callable;

@Command(name = "pirate", subcommands = PiratesCommand.GenerateShip.class, mixinStandardHelpOptions = true)
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
    @Command(name = "build-ship", mixinStandardHelpOptions = true)
    static class GenerateShip implements Callable<Integer> {

        private final PirateShipGenerator pirateShipGenerator;

        @Override
        public Integer call() {
            System.out.println(pirateShipGenerator.generateShip());
            return 0;
        }
    }
}

