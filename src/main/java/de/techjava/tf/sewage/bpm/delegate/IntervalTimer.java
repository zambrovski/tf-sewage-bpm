package de.techjava.tf.sewage.bpm.delegate;

import org.springframework.stereotype.Component;

@Component
public class IntervalTimer {

    public String getInterval() {
        return "PT10S";
    }
}
