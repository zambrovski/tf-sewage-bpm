package de.techjava.tf.sewage.bpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import de.techjava.mqtt.camunda.spring.MqttCamundaSpringConfiguration;
import de.techjava.tf.sewage.bpm.delegate.DelegateConfiguration;
import de.techjava.tf.sewage.bpm.delegate.SewageProcess;
import de.techjava.tf.sewage.bpm.interval.PersistenceConfiguration;

@SpringBootApplication
@Configuration
@Import({ PersistenceConfiguration.class, DelegateConfiguration.class, MqttCamundaSpringConfiguration.class })
public class SewageApplication {

    public static void main(final String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(SewageApplication.class, args);
        context.getBean(SewageProcess.class).start();
    }

}
