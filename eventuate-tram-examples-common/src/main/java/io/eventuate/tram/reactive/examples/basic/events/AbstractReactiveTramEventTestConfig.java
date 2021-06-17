package io.eventuate.tram.reactive.examples.basic.events;

import io.eventuate.tram.reactive.examples.basic.events.domain.Account;

public class AbstractReactiveTramEventTestConfig implements IdSupplier, AggregateSupplier {

  private long uniqueId = System.currentTimeMillis();
  private String  aggregateType = Account.class.getName() + uniqueId;
  private String aggregateId = "accountId" + uniqueId;

  @Override
  public Long get() {
    return uniqueId;
  }

  @Override
  public String getAggregateType() {
    return aggregateType;
  }

  @Override
  public String getAggregateId() {
    return aggregateId;
  }
}
