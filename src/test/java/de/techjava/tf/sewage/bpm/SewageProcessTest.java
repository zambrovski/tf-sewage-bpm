package de.techjava.tf.sewage.bpm;

import javax.inject.Inject;

import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.Job;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.assertions.ProcessEngineAssertions;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.extension.mockito.DelegateExpressions;
import org.camunda.bpm.extension.mockito.mock.FluentJavaDelegateMock;
import org.camunda.bpm.extension.needle.ProcessEngineNeedleRule;
import org.camunda.bpm.extension.needle.ProcessEngineNeedleRuleBuilder;
import org.junit.Rule;
import org.junit.Test;

import de.techjava.tf.sewage.bpm.delegate.IntervalTimer;

public class SewageProcessTest {

    @Rule
    public ProcessEngineNeedleRule rule = new ProcessEngineNeedleRuleBuilder(this).build();

    @Inject
    RuntimeService runtime;

    @Inject
    ManagementService management;

    @Test
    @Deployment(resources = SewageProcess.RESOURCE)
    public void should_deploy() {
        //
    }

    @Test
    @Deployment(resources = SewageProcess.RESOURCE)
    public void should_start() {

        DelegateExpressions.autoMock(SewageProcess.RESOURCE);
        Mocks.register("intervalTimer", new IntervalTimer());

        final ProcessInstance instance = runtime.startProcessInstanceByKey(SewageProcess.KEY);
        ProcessEngineAssertions.assertThat(instance).isWaitingAtExactly("event_gateway");
    }

    @Test
    @Deployment(resources = SewageProcess.RESOURCE)
    public void should_start_and_receive_signal() {

        DelegateExpressions.autoMock(SewageProcess.RESOURCE);
        FluentJavaDelegateMock analyse_mock = DelegateExpressions.registerJavaDelegateMock(SewageProcess.Activites.ANALYSE_INTERVAL);
        analyse_mock.onExecutionSetVariables(Variables.createVariables().putValue("violationDetected", false));
        Mocks.register("intervalTimer", new IntervalTimer());

        final ProcessInstance instance = runtime.startProcessInstanceByKey(SewageProcess.KEY);
        ProcessEngineAssertions.assertThat(instance).isWaitingAtExactly("event_gateway");

        runtime.signalEventReceived("interval_received");
        ProcessEngineAssertions.assertThat(instance).isWaitingAtExactly("service_persist");

        Job persistJob = management.createJobQuery().active().singleResult();
        management.executeJob(persistJob.getId());
        ProcessEngineAssertions.assertThat(instance).isWaitingAtExactly("event_gateway");

        DelegateExpressions.verifyJavaDelegateMock(SewageProcess.Activites.ANALYSE_INTERVAL);
        DelegateExpressions.verifyJavaDelegateMock(SewageProcess.Activites.PERSIST_INTERVAL);
    }

}
