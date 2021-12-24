package io.pratiks.stream.influx.model;


import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

@Measurement(name = "cpu_load_short")
public class Cpu {


    @Column(name = "host")
    private String host;

    @Column(name = "region")
    private String region;

    @Column(name = "value")
    private String value;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "host='" + host + '\'' +
                ", region='" + region + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
