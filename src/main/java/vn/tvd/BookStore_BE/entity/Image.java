package vn.tvd.BookStore_BE.entity;

import lombok.Data;

@Data
public class Image {
    private int imageId;
    private String imageName;
    private boolean isThumbnail;
    private String urlImage;
    private String dataImage;
    private Book book;
}