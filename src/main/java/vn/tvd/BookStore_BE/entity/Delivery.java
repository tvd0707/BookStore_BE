package vn.tvd.BookStore_BE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private int deliveryId;

    @Column(name = "delivery_name")
    private String deliveryName;

    @Column(name = "delivery_desc")
    private String deliveryDesc;

    @Column(name = "delivery_fee")
    private double deliveryFee;

    @OneToMany(mappedBy = "delivery",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    List<Order> orderList;
}
