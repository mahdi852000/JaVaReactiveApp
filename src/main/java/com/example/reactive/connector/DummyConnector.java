package com.example.reactive.connector;

import reactor.core.publisher.Sinks;

public class DummyConnector implements Connector {

    private final Sinks.Many<String> sink;

    public DummyConnector(Sinks.Many<String> sink) {
        this.sink = sink;
    }

    @Override
    public void send(String message) {
        sink.tryEmitNext(message);
    }
}
