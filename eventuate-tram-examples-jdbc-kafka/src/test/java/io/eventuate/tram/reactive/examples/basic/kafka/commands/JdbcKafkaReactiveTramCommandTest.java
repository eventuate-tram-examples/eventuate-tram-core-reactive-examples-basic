package io.eventuate.tram.reactive.examples.basic.kafka.commands;

import io.eventuate.tram.reactive.examples.basic.commands.AbstractReactiveTramCommandTest;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = JdbcKafkaReactiveTramCommandTestConfiguration.class)
public class JdbcKafkaReactiveTramCommandTest extends AbstractReactiveTramCommandTest {
}
