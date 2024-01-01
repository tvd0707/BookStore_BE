package vn.tvd.BookStore_BE.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.tvd.BookStore_BE.entity.Category;

@RepositoryRestResource(path = "categories")
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
