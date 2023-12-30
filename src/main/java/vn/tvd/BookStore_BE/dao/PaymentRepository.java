package vn.tvd.BookStore_BE.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.tvd.BookStore_BE.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
