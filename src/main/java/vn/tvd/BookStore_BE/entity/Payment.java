package vn.tvd.BookStore_BE.entity;

import lombok.Data;

import java.util.List;

@Data
public class Payment {
    private int paymentId;
    private String paymentName;
    private String paymentDesc;
    private double paymentFee;
    List<Order> orderList;
}
