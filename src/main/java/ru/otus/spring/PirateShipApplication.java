package ru.otus.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;
import ru.otus.spring.cli.PiratesCommand;

@RequiredArgsConstructor
@SpringBootApplication
public class PirateShipApplication implements CommandLineRunner, ExitCodeGenerator {

    private final CommandLine.IFactory factory;
    private final PiratesCommand piratesCommand;
    private int exitCode = 0;

    @Override
    public void run(String... args) {
        exitCode = new CommandLine(piratesCommand, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(PirateShipApplication.class, args)));
    }
}
