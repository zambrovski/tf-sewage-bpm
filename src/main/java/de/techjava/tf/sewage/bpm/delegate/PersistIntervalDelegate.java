package de.techjava.tf.sewage.bpm.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.techjava.tf.sewage.bpm.interval.IntervalRepository;

@Component(value = "PersistInterval")
public class PersistIntervalDelegate implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersistIntervalDelegate.class);

    @Autowired
    IntervalRepository repository;

    @Override
    public void execute(final DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Persist the interval for further use.");

    }

}