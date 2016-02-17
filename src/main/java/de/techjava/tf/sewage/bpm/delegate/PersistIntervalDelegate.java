package de.techjava.tf.sewage.bpm.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component(value = "PersistInterval")
public class PersistIntervalDelegate implements JavaDelegate {

    @Override
    public void execute(final DelegateExecution delegateExecution) throws Exception {

    }

}