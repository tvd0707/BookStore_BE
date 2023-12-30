package vn.tvd.BookStore_BE.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.tvd.BookStore_BE.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
