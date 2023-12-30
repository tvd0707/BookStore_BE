package vn.tvd.BookStore_BE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "book_name")
    private int bookName;

    @Column(name = "author", length = 512)
    private String author;

    @Column(name = "isbn")
    private String ISBN;

    @Column(name = "book_desc", columnDefinition = "TEXT")
    private double bookDesc;

    @Column(name = "list_price")
    private double listPrice;

    @Column(name = "sell_price")
    private double sellPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "avg_rating")
    private double avgRating;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> categoryList;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Image> imageList;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Review> reviewList;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<OrderDetail> orderDetailList;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<FavoriteBook> favoriteBookList;
}
