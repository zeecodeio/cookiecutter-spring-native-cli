package {{cookiecutter.package_name}};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("HelloWordService")
public class HelloWord implements IHelloService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWord.class);

    @Override
    public void sayHello(String name) {
        LOGGER.info("Hello, {}!", name != null ? name : "world");
    }
}
