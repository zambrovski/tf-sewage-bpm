package de.techjava.tf.sewage.bpm.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("sendAlarm")
public class SendAlarmDelegate implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendAlarmDelegate.class);

    @Override
    public void execute(final DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Alarm {}", delegateExecution.getBpmnModelElementInstance().getName());
    }

}
