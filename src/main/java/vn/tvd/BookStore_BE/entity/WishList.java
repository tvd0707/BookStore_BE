package vn.tvd.BookStore_BE.entity;

import lombok.Data;

@Data
public class WishList {
    private int wishListId;
    User user;
    Book book;
}
