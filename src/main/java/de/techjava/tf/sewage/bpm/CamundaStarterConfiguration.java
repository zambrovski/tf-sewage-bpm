package de.techjava.tf.sewage.bpm;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import de.techjava.mqtt.camunda.spring.MqttCamundaSpringConfiguration;
import de.techjava.tf.sewage.bpm.delegate.DelegateConfiguration;
import de.techjava.tf.sewage.bpm.interval.PersistenceConfiguration;

@Configuration
@Import({ PersistenceConfiguration.class, DelegateConfiguration.class, MqttCamundaSpringConfiguration.class })
public class CamundaStarterConfiguration {

}
