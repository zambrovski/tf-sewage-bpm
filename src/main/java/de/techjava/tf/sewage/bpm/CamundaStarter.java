package de.techjava.tf.sewage.bpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import de.techjava.tf.sewage.bpm.delegate.SewageProcess;

@SpringBootApplication
public class CamundaStarter {

    public static void main(final String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(CamundaStarterConfiguration.class, args);
        context.getBean(SewageProcess.class).start();
    }

}
