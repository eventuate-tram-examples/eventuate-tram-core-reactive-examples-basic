package io.eventuate.tram.reactive.examples.basic.kafka.commands;

import io.eventuate.tram.reactive.examples.basic.commands.AbstractReactiveTramCommandTestConfiguration;
import io.eventuate.tram.spring.reactive.jdbckafka.ReactiveTramJdbcKafkaConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import({AbstractReactiveTramCommandTestConfiguration.class, ReactiveTramJdbcKafkaConfiguration.class, })
public class JdbcKafkaReactiveTramCommandTestConfiguration {
}
