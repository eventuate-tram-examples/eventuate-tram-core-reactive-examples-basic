package io.eventuate.tram.reactive.examples.basic.commands;

import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.reactive.commands.consumer.ReactiveCommandHandlers;
import io.eventuate.tram.reactive.commands.consumer.ReactiveCommandHandlersBuilder;
import org.reactivestreams.Publisher;

import static io.eventuate.tram.reactive.commands.consumer.ReactiveCommandHandlerReplyBuilder.withSuccess;


public class ReactiveTramCommandTestCommandHandler {

  public ReactiveCommandHandlers getCommandHandlers() {
    return ReactiveCommandHandlersBuilder
            .fromChannel(commandChannel)
            .onMessage(ReserveCreditCommand.class, this::reserveCredit)
            .build();

  }
  public Publisher<Message> reserveCredit(CommandMessage<ReserveCreditCommand> cm) {
    return withSuccess();
  }

  private String commandChannel;

  public ReactiveTramCommandTestCommandHandler(String commandChannel) {
    this.commandChannel = commandChannel;
  }


}
