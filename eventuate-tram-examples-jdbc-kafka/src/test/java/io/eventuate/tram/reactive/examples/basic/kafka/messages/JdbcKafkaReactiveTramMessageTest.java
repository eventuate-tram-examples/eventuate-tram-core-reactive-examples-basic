package io.eventuate.tram.reactive.examples.basic.kafka.messages;

import io.eventuate.tram.reactive.examples.basic.messages.AbstractReactiveTramMessageTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = JdbcKafkaReactiveTramMessageTestConfiguration.class)
public class JdbcKafkaReactiveTramMessageTest extends AbstractReactiveTramMessageTest {
}
