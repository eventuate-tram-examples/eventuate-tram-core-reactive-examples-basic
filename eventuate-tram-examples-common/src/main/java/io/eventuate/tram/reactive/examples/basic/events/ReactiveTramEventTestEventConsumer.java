package io.eventuate.tram.reactive.examples.basic.events;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.reactive.examples.basic.events.domain.AccountDebited;
import io.eventuate.tram.reactive.events.subscriber.ReactiveDomainEventHandlers;
import io.eventuate.tram.reactive.events.subscriber.ReactiveDomainEventHandlersBuilder;
import reactor.core.publisher.Mono;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ReactiveTramEventTestEventConsumer {

  private BlockingQueue<AccountDebited> queue = new LinkedBlockingDeque<>();
  private String aggregateType;

  public ReactiveTramEventTestEventConsumer(String aggregateType) {
    this.aggregateType = aggregateType;
  }

  public ReactiveDomainEventHandlers domainEventHandlers() {
    return ReactiveDomainEventHandlersBuilder
            .forAggregateType(aggregateType)
            .onEvent(AccountDebited.class, this::handleAccountDebited)
            .build();
  }

  public Mono<?> handleAccountDebited(DomainEventEnvelope<AccountDebited> event) {
    return Mono.defer(() -> Mono.just(queue.add(event.getEvent())));
  }

  public BlockingQueue<AccountDebited> getQueue() {
    return queue;
  }
}
