package io.eventuate.tram.reactive.examples.basic.kafka.commands;

import io.eventuate.tram.reactive.examples.basic.commands.AbstractReactiveTramCommandTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = JdbcKafkaReactiveTramCommandTestConfiguration.class)
public class JdbcKafkaReactiveTramCommandTest extends AbstractReactiveTramCommandTest {
}
