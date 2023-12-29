package vn.tvd.BookStore_BE.entity;

import lombok.Data;

import java.util.List;

@Data
public class Delivery {
    private int deliveryId;
    private String deliveryName;
    private String deliveryDesc;
    private double deliveryFee;
    List<Order> orderList;
}
