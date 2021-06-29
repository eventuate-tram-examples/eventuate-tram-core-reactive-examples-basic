package io.eventuate.tram.reactive.examples.basic.kafka.messages;

import io.eventuate.tram.spring.reactive.jdbckafka.ReactiveTramJdbcKafkaConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import(ReactiveTramJdbcKafkaConfiguration.class)
public class JdbcKafkaReactiveTramMessageTestConfiguration {
}
