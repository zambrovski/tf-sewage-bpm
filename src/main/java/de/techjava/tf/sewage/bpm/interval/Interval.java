package de.techjava.tf.sewage.bpm.interval;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

/**
 * Represents a time interval measured by a sensor.
 * 
 * @author Simon Zambrovski
 * 
 */
@Entity
@Table(name = "interval_measurement")
@NamedQuery(name = Interval.LAST_TWO, query = "select i from Interval as i order by i.end desc")
public class Interval {
    public final static String LAST_TWO = "Interval.lastTwo";
    private final static SimpleDateFormat SDF = new SimpleDateFormat();

    private long id;
    private long start;
    private long end;
    private String sensorId;

    public Interval() {
        this(-1, -1, "NONE");
    }

    public Interval(long start, long end, String sensorId) {
        this.start = start;
        this.end = end;
        this.sensorId = sensorId;
    }

    @Column(name = "stop_time")
    public long getEnd() {
        return end;
    }

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "sensor_id")
    @Basic(optional = false)
    public String getSensorId() {
        return sensorId;
    }

    @Column(name = "start_time")
    @Basic(optional = false)
    public long getStart() {
        return start;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public void setStart(long start) {
        this.start = start;
    }

    @Override
    public String toString() {
        final Date startD = new Date(start);
        final Date endD = new Date(end);
        return "Interval [sensorId=" + sensorId + ", start=" + SDF.format(startD) + ", end=" + SDF.format(endD) + "]";
    }
}