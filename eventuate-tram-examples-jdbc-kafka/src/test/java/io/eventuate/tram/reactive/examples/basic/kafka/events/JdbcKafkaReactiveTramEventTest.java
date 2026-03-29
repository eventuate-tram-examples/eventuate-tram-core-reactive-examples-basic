package io.eventuate.tram.reactive.examples.basic.kafka.events;

import io.eventuate.tram.reactive.examples.basic.events.AbstractReactiveTramEventTest;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = JdbcKafkaReactiveTramEventTestConfiguration.class)
public class JdbcKafkaReactiveTramEventTest extends AbstractReactiveTramEventTest {
}
