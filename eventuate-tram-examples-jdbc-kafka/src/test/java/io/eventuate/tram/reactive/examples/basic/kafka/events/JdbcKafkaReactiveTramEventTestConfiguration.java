package io.eventuate.tram.reactive.examples.basic.kafka.events;

import io.eventuate.tram.reactive.examples.basic.events.AbstractReactiveTramEventTestConfiguration;
import io.eventuate.tram.spring.reactive.jdbckafka.ReactiveTramJdbcKafkaConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import({AbstractReactiveTramEventTestConfiguration.class, ReactiveTramJdbcKafkaConfiguration.class})
public class JdbcKafkaReactiveTramEventTestConfiguration {
}
