package vn.tvd.BookStore_BE.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import vn.tvd.BookStore_BE.entity.Book;
import org.springframework.data.domain.Page;
@RepositoryRestResource(path = "books")
public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findByBookNameContaining(@RequestParam("book-name") String bookName, Pageable pageable);

    Page<Book> findByCategoryList_categoryId(@RequestParam("category-id") int categoryId, Pageable pageable);

    Page<Book> findByBookNameContainingAndCategoryList_categoryId(@RequestParam("book-name") String bookName, @RequestParam("category-id") int categoryId, Pageable pageable);
}
