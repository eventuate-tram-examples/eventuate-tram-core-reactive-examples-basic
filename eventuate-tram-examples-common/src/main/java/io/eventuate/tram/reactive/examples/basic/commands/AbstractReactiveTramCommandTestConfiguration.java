package io.eventuate.tram.reactive.examples.basic.commands;

import io.eventuate.tram.reactive.commands.consumer.ReactiveCommandDispatcher;
import io.eventuate.tram.reactive.commands.consumer.ReactiveCommandDispatcherFactory;
import io.eventuate.tram.spring.reactive.commands.consumer.ReactiveTramCommandConsumerConfiguration;
import io.eventuate.tram.spring.reactive.commands.producer.ReactiveTramCommandProducerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ReactiveTramCommandProducerConfiguration.class, ReactiveTramCommandConsumerConfiguration.class})
public class AbstractReactiveTramCommandTestConfiguration {

  @Bean
  public AbstractReactiveTramCommandTestConfig testConfig() {
    return new AbstractReactiveTramCommandTestConfig();
  }

  @Bean
  public ReactiveTramCommandTestCommandHandler commandHandler(AbstractReactiveTramCommandTestConfig config) {
    return new ReactiveTramCommandTestCommandHandler(config.getCommandChannel());
  }

  @Bean
  public ReactiveCommandDispatcher commandDispatcher(ReactiveCommandDispatcherFactory commandDispatcherFactory,
                                                     AbstractReactiveTramCommandTestConfig config, ReactiveTramCommandTestCommandHandler target) {
    return commandDispatcherFactory.make(config.getCommandDispatcheId(), target.getCommandHandlers());
  }

}
