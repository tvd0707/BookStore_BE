package vn.tvd.BookStore_BE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "payment_name")
    private String paymentName;

    @Column(name = "payment_desc")
    private String paymentDesc;

    @Column(name = "payment_fee")
    private double paymentFee;

    @OneToMany(mappedBy = "payment",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    List<Order> orderList;
}
