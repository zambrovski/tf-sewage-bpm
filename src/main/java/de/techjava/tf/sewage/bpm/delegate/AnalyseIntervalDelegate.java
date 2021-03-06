package de.techjava.tf.sewage.bpm.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component(value = "AnalyseInterval")
public class AnalyseIntervalDelegate implements JavaDelegate {

    @Override
    public void execute(final DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable(SewageProcess.Variables.VIOLATION_DETECTED, true);
    }

}
