package vn.tvd.BookStore_BE.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private int imageId;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "is_thumbnail")
    private boolean isThumbnail;

    @Column(name = "url_image", length = 512)
    private String urlImage;

    @Column(name = "data_image", columnDefinition = "LONGTEXT")
    @Lob
    private String dataImage;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "book_id", nullable = false)
    Book book;
}