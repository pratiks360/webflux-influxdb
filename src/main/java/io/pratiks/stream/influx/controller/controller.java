package io.pratiks.stream.influx.controller;

import io.pratiks.stream.influx.model.Cpu;
import io.pratiks.stream.influx.service.InfluxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/live")
public class controller {

    @Autowired
    private InfluxService cpuService;

    @GetMapping(produces = "text/event-stream")
    public Flux<Cpu> getLatestValue() {
        return cpuService.fetch();

    }
}
