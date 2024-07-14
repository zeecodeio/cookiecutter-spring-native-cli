package {{cookiecutter.package_name}};

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.IFactory;

@SpringBootApplication
@Command(name = "{{cookiecutter.cli_name}}", mixinStandardHelpOptions = true, version = "1.0",
        description = "{{cookiecutter.cli_description}}")
public class Application implements CommandLineRunner, ExitCodeGenerator {

    private IFactory factory;
    private GreetCommand greetCommand;
    private int exitCode;

    Application(IFactory factory, GreetCommand greetCommand) {
        this.factory = factory;
        this.greetCommand = greetCommand;
    }

    @Override
    public void run(String... args) {
        exitCode = new CommandLine(greetCommand, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(Application.class, args)));
    }

}
