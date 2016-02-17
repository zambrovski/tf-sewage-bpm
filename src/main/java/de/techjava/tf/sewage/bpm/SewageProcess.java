package de.techjava.tf.sewage.bpm;

public class SewageProcess {

    public static final String RESOURCE = "tf-sewage.bpmn";

    public static final String KEY = "tf-sewage";

    public enum Activites {
        ;
        public final static String ANALYSE_INTERVAL = "analyseInterval";
        public final static String PERSIST_INTERVAL = "persistInterval";
    }
}
