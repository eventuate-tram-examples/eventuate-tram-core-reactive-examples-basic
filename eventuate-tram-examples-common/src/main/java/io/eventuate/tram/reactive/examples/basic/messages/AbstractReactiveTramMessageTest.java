package io.eventuate.tram.reactive.examples.basic.messages;

import io.eventuate.tram.consumer.common.reactive.ReactiveMessageConsumer;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.messaging.producer.MessageBuilder;
import io.eventuate.tram.reactive.messaging.producer.common.ReactiveMessageProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public abstract class AbstractReactiveTramMessageTest {

  private long uniqueId = System.currentTimeMillis();

  private String subscriberId = "subscriberId" + uniqueId;
  private String destination = "destination" + uniqueId;
  private String payload = "{" + "\"Hello\":" + uniqueId + "}";

  @Autowired
  private ReactiveMessageProducer messageProducer;

  @Autowired
  private ReactiveMessageConsumer messageConsumer;

  private BlockingQueue<Message> queue = new LinkedBlockingDeque<>();

  @Test
  public void shouldReceiveMessage() throws InterruptedException {
    messageConsumer.subscribe(subscriberId, Collections.singleton(destination), this::handleMessage);
    messageProducer.send(destination, MessageBuilder.withPayload(payload).build()).block();

    Message m = queue.poll(10, TimeUnit.SECONDS);

    assertNotNull(m);
    assertEquals(payload, m.getPayload());
  }

  private Mono<?> handleMessage(Message message) {
    return Mono.defer(() -> Mono.just(queue.add(message)));
  }
}
