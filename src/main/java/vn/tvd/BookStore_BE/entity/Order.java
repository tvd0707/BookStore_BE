package vn.tvd.BookStore_BE.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private int orderId;
    private Date dateCreated;
    private String orderAddress;
    private String deliveryAddress;
    private double totalPriceProduct;
    private double feeDelivery;
    private double feePayment;
    private double totalPrice;
    List<OrderDetail> orderDetailList;
    User user;
    Payment payment;
    Delivery delivery;

}
