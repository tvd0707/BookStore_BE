package vn.tvd.BookStore_BE.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private long reviewId;

    @Column(name = "rating_point")
    private float ratingPoint;

    @Column(name = "review_content")
    private String reviewContent;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "book_id", nullable = false)
    Book book;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable = false)
    User user;
}
