package de.techjava.tf.sewage.persist.interval;

/**
 * Provides a listener for intervals.
 * 
 * @author Simon Zambrovski
 * 
 */
public interface IntervalListener {

    /**
     * Event fires if an interval is detected.
     * 
     * @param interval
     *            detected interval
     */
    void intervalDetected(final Interval interval);
}