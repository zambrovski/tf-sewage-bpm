package de.techjava.tf.sewage.bpm.delegate;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = IntervalTimer.class)
public class DelegateConfiguration {

}
