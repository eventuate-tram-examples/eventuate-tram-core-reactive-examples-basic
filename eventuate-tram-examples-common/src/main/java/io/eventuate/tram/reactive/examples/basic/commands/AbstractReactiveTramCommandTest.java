package io.eventuate.tram.reactive.examples.basic.commands;

import io.eventuate.tram.commands.common.ReplyMessageHeaders;
import io.eventuate.tram.consumer.common.reactive.ReactiveMessageConsumer;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.reactive.commands.producer.ReactiveCommandProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public abstract class AbstractReactiveTramCommandTest {

  @Autowired
  private ReactiveCommandProducer commandProducer;

  @Autowired
  private AbstractReactiveTramCommandTestConfig config;

  @Autowired
  private ReactiveMessageConsumer messageConsumer;

  private BlockingQueue<Message> queue = new LinkedBlockingDeque<>();

  @Test
  public void shouldInvokeCommand() throws InterruptedException {
    subscribeToReplyChannel();

    String commandId = sendCommand();

    assertReplyReceived(commandId);
  }

  private void assertReplyReceived(String commandId) throws InterruptedException {
    Message m = queue.poll(10, TimeUnit.SECONDS);
    assertNotNull("Expected reply by deadline", m);
    assertEquals(commandId, m.getRequiredHeader(ReplyMessageHeaders.IN_REPLY_TO));
  }

  private String sendCommand() {
    return commandProducer
            .send(config.getCommandChannel(),
                    new ReserveCreditCommand(),
                    config.getReplyChannel(),
                    Collections.emptyMap())
            .block();
  }

  private void subscribeToReplyChannel() {
    String subscriberId = "subscriberId" + config.getUniqueId();
    messageConsumer.subscribe(subscriberId, Collections.singleton(config.getReplyChannel()), this::handleMessage);
  }

  private Mono<?> handleMessage(Message message) {
    return Mono.defer(() -> Mono.just(queue.add(message)));
  }
}
