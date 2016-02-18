package de.techjava.tf.sewage.bpm.delegate;

import java.util.List;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SewageProcess implements ApplicationContextAware {

    public static final String RESOURCE = "tf-sewage.bpmn";
    public static final String KEY = "tf-sewage";

    public enum Activites {
        ;
        public final static String ANALYSE_INTERVAL_EL = "analyseInterval";
        public final static String PERSIST_INTERVAL_EL = "persistInterval";
        public final static String TERMINATE_MESSAGE = "terminate_message";

    }

    public enum Variables {
        ;
        public final static String VIOLATION_DETECTED = "violationDetected";
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(SewageProcess.class);

    @Autowired
    private RuntimeService runtimeService;
    private ApplicationContext context;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void start() {

        final List<ProcessInstance> processes = runtimeService.createProcessInstanceQuery().processDefinitionKey(KEY).active().list();
        for (ProcessInstance instance : processes) {
            try {
                runtimeService.deleteProcessInstance(instance.getProcessInstanceId(), "Restart");
            } catch (Exception e) {
            }
        }
        LOGGER.info("Stopped {} instances.", processes.size());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(KEY);
        LOGGER.info("Started instance of {} with id {}", KEY, processInstance.getId());
    }

    public void terminate() {
        runtimeService.correlateMessage("terminate_message");
    }
}
