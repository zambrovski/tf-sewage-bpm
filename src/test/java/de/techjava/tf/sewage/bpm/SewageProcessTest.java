package de.techjava.tf.sewage.bpm;

import javax.inject.Inject;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.extension.needle.ProcessEngineNeedleRule;
import org.camunda.bpm.extension.needle.ProcessEngineNeedleRuleBuilder;
import org.junit.Rule;
import org.junit.Test;

public class SewageProcessTest {

    @Rule
    public ProcessEngineNeedleRule rule = new ProcessEngineNeedleRuleBuilder(this).build();

    @Inject
    RuntimeService runtime;

    @Test
    @Deployment(resources = "tf-sewage-bpm.bpmn")
    public void should_deploy() {
        //
    }
}
