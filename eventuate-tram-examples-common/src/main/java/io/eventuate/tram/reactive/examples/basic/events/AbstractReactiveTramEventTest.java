package io.eventuate.tram.reactive.examples.basic.events;

import io.eventuate.tram.events.common.DomainEvent;
import io.eventuate.tram.reactive.examples.basic.events.domain.AccountDebited;
import io.eventuate.tram.spring.events.publisher.ReactiveDomainEventPublisher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public abstract class AbstractReactiveTramEventTest {

  @Autowired
  private ReactiveDomainEventPublisher domainEventPublisher;

  @Autowired
  private AbstractReactiveTramEventTestConfig config;

  @Autowired
  private ReactiveTramEventTestEventConsumer tramEventTestEventConsumer;

  @Test
  public void shouldReceiveEvent() throws InterruptedException {
    long uniqueId = config.get();

    DomainEvent domainEvent = new AccountDebited(uniqueId);

    domainEventPublisher
            .publish(config.getAggregateType(), config.getAggregateId(), Collections.singletonList(domainEvent))
            .block();


    AccountDebited event = tramEventTestEventConsumer.getQueue().poll(10, TimeUnit.SECONDS);

    assertNotNull(event);
    assertEquals(uniqueId, event.getAmount());
  }

}
