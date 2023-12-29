package vn.tvd.BookStore_BE.entity;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private int bookId;
    private int bookName;
    private String author;
    private String ISBN;
    private double bookDesc;
    private double listPrice;
    private double sellPrice;
    private int quantity;
    private double avgRating;
    List<Category> categoryList;
    List<Review> reviewList;
    List<Image> imageList;
    List<OrderDetail> orderDetailList;
    List<WishList> wishListList;
}
