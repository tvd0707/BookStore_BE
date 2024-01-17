package vn.tvd.BookStore_BE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.tvd.BookStore_BE.entity.User;
import vn.tvd.BookStore_BE.service.AccountService;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Validated @RequestBody User user) {
        ResponseEntity<?> response = accountService.registerUser(user);
        return response;
    }

    @GetMapping("/active")
    public ResponseEntity<?> activeUser(@RequestParam String email, @RequestParam String activeCode) {
        ResponseEntity<?> response = accountService.activeAccount(email, activeCode);
        return response;

    }
}
