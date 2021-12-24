package io.pratiks.stream.influx.service;

import io.pratiks.stream.influx.model.Cpu;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.influxdb.InfluxDBTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class InfluxService {

    private static final String SELECT_LATEST = "select * from cpu_load_short limit 1";
    @Autowired
    private InfluxDBTemplate<Point> influxDBTemplate;
    private final InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();

    public Flux<Cpu> fetch() {

        Query query = new Query(SELECT_LATEST, influxDBTemplate.getDatabase());
        QueryResult result = influxDBTemplate.query(query);
        List<Cpu> cpuList = resultMapper.toPOJO(result, Cpu.class);
        Flux<Cpu> single = Flux.just(cpuList.get(0));
        return single;

    }


}
