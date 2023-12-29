package vn.tvd.BookStore_BE.entity;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private int categoryId;
    private String categoryName;
    List<Book> bookList;
}
