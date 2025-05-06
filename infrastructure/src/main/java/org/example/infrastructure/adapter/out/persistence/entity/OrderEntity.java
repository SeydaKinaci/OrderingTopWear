package org.example.infrastructure.adapter.out.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import se.iths.LineItem;
import se.iths.Location;
import se.iths.Order;
import se.iths.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table("order")
public class OrderEntity {

    @Id
    private long id;

    @Column("uuid")
    private UUID uuid;

    private Location location;

    private OrderStatus status;

    private LocalDateTime orderDate;

    @MappedCollection(idColumn = "order_id", keyColumn = "order_key")
    private List<LineItemEntity> items;

    public OrderEntity() {
    }

    public OrderEntity(long id, UUID uuid, Location location, OrderStatus status, LocalDateTime orderDate, List<LineItemEntity> items) {
        this.id = id;
        this.uuid = uuid;
        this.location = location;
        this.status = status;
        this.orderDate = orderDate;
        this.items = items;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<LineItemEntity> getItems() {
        return items;
    }

    public void setItems(List<LineItemEntity> items) {
        this.items = items;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof OrderEntity that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    public Order toDomain() {
        return new Order(this.items.stream().map(LineItemEntity::toDomain).toList(),
                this.location);
    }

    public static OrderEntity fromDomain(Order order) {
        var orderEntity = new OrderEntity();
        orderEntity.setUuid(order.getId());
        orderEntity.setLocation(order.getLocation());
        orderEntity.setOrderDate(order.getOrderDate());
        orderEntity.setStatus(order.getStatus());
        orderEntity.setItems(order.getItems()
                .stream()
                .map(LineItemEntity::fromDomain)
                .toList());

        return orderEntity;
    }
}
