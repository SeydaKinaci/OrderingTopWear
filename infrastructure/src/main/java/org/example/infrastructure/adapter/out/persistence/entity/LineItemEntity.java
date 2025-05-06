package org.example.infrastructure.adapter.out.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import se.iths.*;

import java.util.Objects;

@Table("order_item")
public class LineItemEntity {

    @Id
    private Long id;

    @Column("order_id")
    private Long orderId;

    @Column("order_key")
    private int orderKey;

    private SleeveType sleeveType;

    private Color color;

    private Size size;

    private int quantity;


    public LineItemEntity(Long id, Long orderId, int orderKey, SleeveType sleeveType, Color color, Size size, int quantity, double unitPrice) {
        this.id = id;
        this.orderId = orderId;
        this.orderKey = orderKey;
        this.sleeveType = sleeveType;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }

    public LineItemEntity( ){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SleeveType getSleeveType() {
        return sleeveType;
    }

    public void setSleeveType(SleeveType sleeveType) {
        this.sleeveType = sleeveType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LineItemEntity that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 25;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(int orderKey) {
        this.orderKey = orderKey;
    }

    public static LineItemEntity fromDomain(LineItem lineItem) {

            TopWear topWear = lineItem.topWear();

            LineItemEntity entity = new LineItemEntity();

            entity.setSleeveType(topWear.sleeveType());
            entity.setColor(topWear.color());
            entity.setSize(topWear.size());
            entity.setQuantity(lineItem.quantity());

            return entity;
        }


    public LineItem toDomain() {
        TopWear topWear = new TopWear(this.sleeveType, this.color, this.size);
        return new LineItem(topWear, this.quantity);
    }

}
