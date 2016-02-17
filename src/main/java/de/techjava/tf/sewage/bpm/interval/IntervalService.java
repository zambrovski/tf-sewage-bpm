package de.techjava.tf.sewage.bpm.interval;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface IntervalService extends CrudRepository<Interval, Integer> {

}
