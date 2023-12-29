package vn.tvd.BookStore_BE.entity;

import lombok.Data;

@Data
public class Review {
    private long reviewId;
    private float ratingPoint;
    private String reviewContent;
    Book book;
    User user;
}
