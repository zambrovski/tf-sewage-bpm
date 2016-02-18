package de.techjava.tf.sewage.bpm.interval;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "start_time")
    @Basic(optional = false)
    private long start;
    @Column(name = "stop_time")
    private long end;
    @Column(name = "sensor_id")
    @Basic(optional = false)
    private String sensorId;

    public Interval() {
        this(-1, -1, "NONE");
    }

    public Interval(long start, long end, String sensorId) {
        this.start = start;
        this.end = end;
        this.sensorId = sensorId;
    }

    public long getEnd() {
        return end;
    }

    public long getId() {
        return id;
    }

    public String getSensorId() {
        return sensorId;
    }

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