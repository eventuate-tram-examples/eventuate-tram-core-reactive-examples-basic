package io.eventuate.tram.reactive.examples.basic.events;

import io.eventuate.tram.reactive.events.subscriber.ReactiveDomainEventDispatcher;
import io.eventuate.tram.reactive.events.subscriber.ReactiveDomainEventDispatcherFactory;
import io.eventuate.tram.spring.events.publisher.ReactiveTramEventsPublisherConfiguration;
import io.eventuate.tram.spring.reactive.events.subscriber.ReactiveTramEventSubscriberConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ReactiveTramEventsPublisherConfiguration.class, ReactiveTramEventSubscriberConfiguration.class})
public class AbstractReactiveTramEventTestConfiguration {

  @Bean
  public IdSupplier idSupplier() {
    return new AbstractReactiveTramEventTestConfig();
  }

  @Bean
  public ReactiveDomainEventDispatcher domainEventDispatcher(ReactiveDomainEventDispatcherFactory domainEventDispatcherFactory,
                                                             IdSupplier idSupplier,
                                                             ReactiveTramEventTestEventConsumer target) {
    return domainEventDispatcherFactory.make("eventDispatcherId" + idSupplier.get(),
            target.domainEventHandlers());
  }

  @Bean
  public ReactiveTramEventTestEventConsumer eventTestTarget(AggregateSupplier aggregateSupplier) {
    return new ReactiveTramEventTestEventConsumer(aggregateSupplier.getAggregateType());
  }


}
