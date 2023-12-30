package vn.tvd.BookStore_BE.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.tvd.BookStore_BE.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
