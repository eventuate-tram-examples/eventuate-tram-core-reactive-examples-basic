package io.eventuate.tram.reactive.examples.basic.events;

public interface AggregateSupplier {
  String getAggregateType();

  String getAggregateId();
}
