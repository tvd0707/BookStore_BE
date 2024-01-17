package vn.tvd.BookStore_BE.service.User;

import org.springframework.security.core.userdetails.UserDetailsService;
import vn.tvd.BookStore_BE.entity.User;

public interface UserService extends UserDetailsService {
    public User findByUsername(String username);
}
