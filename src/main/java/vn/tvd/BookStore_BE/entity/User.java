package vn.tvd.BookStore_BE.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private char gender;
    private String email;
    private String phone;
    private String deliveryAddress;
    private String orderAddress;
    List<Review> reviewList;
    List<WishList> wishListList;
    List<Role> roleList;
    List<Order> orderList;

}
