package vn.tvd.BookStore_BE.entity;

import lombok.Data;

@Data
public class OrderDetail {
    private long orderDetailId;
    private int quantity;
    private double price;
    Book book;
    Order order;
}
