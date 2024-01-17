package vn.tvd.BookStore_BE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vn.tvd.BookStore_BE.dao.UserRepository;
import vn.tvd.BookStore_BE.entity.ErrorMessage;
import vn.tvd.BookStore_BE.entity.User;
import vn.tvd.BookStore_BE.service.Email.EmailService;

import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    public ResponseEntity<?> registerUser(User user) {
        //Kiem tra username va email da ton tai hay chua
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body(new ErrorMessage("Username is already taken!"));
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(new ErrorMessage("Email is already taken!"));
        }

        //Ma hoa password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        //Gán và gửi thông tin kch hoạt
        user.setActiveCode(createActiveCode());
        user.setActived(false);

        //Luu user moi vao database
        User newUser = userRepository.save(user);

        //Gui email de user kich hoat
        sendActiveEmail(newUser.getEmail(), newUser.getActiveCode());

        return ResponseEntity.ok("Register successfully!");
    }

    private String createActiveCode() {
        //Tao ra mot chuoi ngau nhien
        return UUID.randomUUID().toString();
    }

    private void sendActiveEmail(String email, String activeCode) {
        String subject = "Kích hoạt tài khoản của bạn tại BookStore";
        String text = "Vui lòng sử dụng mã sau để kich hoạt cho tài khoản <" + email + ">:<html><body><br/><h1>" + activeCode + "</h1></body></html>";
        text += "<br/> Click vào đường link để kích hoạt tài khoản: ";
        String url = "http://localhost:3000/active/" + email + "/" + activeCode;
        text += ("<br/> <a href=" + url + ">" + url + "</a> ");

        emailService.sendEmail("0707tvd@gmail.com", email, subject, text);
    }


    public ResponseEntity<?> activeAccount(String email, String activeCode) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return ResponseEntity.badRequest().body(new ErrorMessage("Email is not exist!"));
        }

        if (user.isActived()) {
            return ResponseEntity.badRequest().body(new ErrorMessage("Account is already actived!"));
        }

        if (activeCode.equals(user.getActiveCode())) {
            user.setActived(true);
            userRepository.save(user);
            return ResponseEntity.ok("Active successfully!");
        } else {
            return ResponseEntity.badRequest().body(new ErrorMessage("Active code is not correct!"));
        }
    }
}
