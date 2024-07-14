package {{cookiecutter.package_name}};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Component
@Command(name = "greet", description = "Greets the user.", mixinStandardHelpOptions = true)
public class GreetCommand implements Callable<Integer> {

    @Autowired
    private IHelloService helloService;

    @Option(names = {"-n", "--name"}, description = "The name of the user.")
    String name;

    @Override
    public Integer call() throws Exception {
        this.helloService.sayHello(name);
        return 0;
    }
}
