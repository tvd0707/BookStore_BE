package vn.tvd.BookStore_BE.service.Email;

public interface EmailService {
    public void sendEmail(String from, String to, String subject, String text);
}
