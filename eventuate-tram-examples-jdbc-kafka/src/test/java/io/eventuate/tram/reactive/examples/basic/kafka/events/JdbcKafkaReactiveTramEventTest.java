package io.eventuate.tram.reactive.examples.basic.kafka.events;

import io.eventuate.tram.reactive.examples.basic.events.AbstractReactiveTramEventTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = JdbcKafkaReactiveTramEventTestConfiguration.class)
public class JdbcKafkaReactiveTramEventTest extends AbstractReactiveTramEventTest {
}
