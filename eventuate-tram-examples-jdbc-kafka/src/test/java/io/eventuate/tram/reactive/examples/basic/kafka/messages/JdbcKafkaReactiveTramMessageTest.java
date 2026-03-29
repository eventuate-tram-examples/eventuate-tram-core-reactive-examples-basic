package io.eventuate.tram.reactive.examples.basic.kafka.messages;

import io.eventuate.tram.reactive.examples.basic.messages.AbstractReactiveTramMessageTest;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = JdbcKafkaReactiveTramMessageTestConfiguration.class)
public class JdbcKafkaReactiveTramMessageTest extends AbstractReactiveTramMessageTest {
}
