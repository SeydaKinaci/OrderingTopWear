package org.example.infrastructure.adapter.out.persistence;

import org.example.infrastructure.adapter.out.persistence.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

    OrderEntity findByUuid(UUID orderId);

}
