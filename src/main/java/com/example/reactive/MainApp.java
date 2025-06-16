package com.example.reactive;

import com.example.reactive.connector.Connector;
import com.example.reactive.connector.DummyConnector;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class MainApp {

    public static void main(String[] args) throws InterruptedException {
        Sinks.Many<String> messageSink = Sinks.many().unicast().onBackpressureBuffer();

        Flux<String> messageFlux = messageSink.asFlux();

        messageFlux.subscribe(message -> System.out.println("Received (reactive): " + message));

        Connector connector = new DummyConnector(messageSink);

        connector.send("Hello Reactive World!");
        connector.send("Another message in Reactive way");
        connector.send("wanna more Message? ");

        Thread.sleep(1000); // allow some time for processing
    }
}
