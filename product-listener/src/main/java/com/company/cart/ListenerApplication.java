package com.company.cart;

import com.company.core.CoreApplication;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.EnableJms;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableJms
@Import(CoreApplication.class)
@ComponentScan(basePackages = {"com.company"})
public class ListenerApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ListenerApplication.class);

    private final Environment env;

    @Inject
    public ListenerApplication(Environment env) {
        this.env = env;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ListenerApplication.class);
        Environment env = app.run(args).getEnvironment();

        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException exception) {
            LOG.error("Host not found : ", exception);
        }

        LOG.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                host,
                env.getProperty("server.port"));

    }

}
