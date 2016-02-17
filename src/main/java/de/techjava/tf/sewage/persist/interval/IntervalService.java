package de.techjava.tf.sewage.persist.interval;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class IntervalService implements IntervalListener {

    private Logger logger = LoggerFactory.getLogger(IntervalService.class);

//    @PersistenceContext
//    private EntityManager em;

    @Override
    public void intervalDetected(Interval interval) {

        logger.info("New interval detected: {}.", interval);
//        em.persist(interval);
    }

}
