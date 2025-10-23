package poly.edu.Impl;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import poly.edu.Service.MailService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;
    List<Mail> queue = new ArrayList<>();
    @Override
    public void send(Mail mail) {
        try {
            // 1. Tạo Mail
            MimeMessage message = mailSender.createMimeMessage();

            // 2. Tạo đối tượng hỗ trợ ghi nội dung Mail
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

            // 2.1. Ghi thông tin người gửi
            helper.setFrom(mail.getFrom());
            helper.setReplyTo(mail.getFrom());

            // 2.2. Ghi thông tin người nhận
            helper.setTo(mail.getTo());
            if (!this.isNullOrEmpty(mail.getCc())) {
                helper.setCc(mail.getCc());
            }
            if (!this.isNullOrEmpty(mail.getBcc())) {
                helper.setBcc(mail.getBcc());
            }

            // 2.3. Ghi tiêu đề và nội dung
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getBody(), true); // true = cho phép HTML

            // 2.4. Đính kèm file
            String filenames = mail.getFilenames();
            if (!this.isNullOrEmpty(filenames)) {
                for (String filename : filenames.split("[,;]+")) {
                    File file = new File(filename.trim());
                    if (file.exists()) { // tránh lỗi nếu file không tồn tại
                        helper.addAttachment(file.getName(), file);
                    } else {
                        System.out.println("⚠️ File không tồn tại: " + filename);
                    }
                }
            }

            // 3. Gửi Mail
            mailSender.send(message);
            System.out.println("✅ Gửi mail thành công đến: " + mail.getTo());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Lỗi khi gửi mail: " + e.getMessage());
        }
    }
    @Override
    public void push(Mail mail) {
        queue.add(mail);
    }
    @Scheduled(fixedDelay = 500)
    public void run() {
        while(!queue.isEmpty()) {
            try {
                this.send(queue.remove(0));
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }
    private boolean isNullOrEmpty(String text) {
        return (text == null || text.trim().length() == 0);
    }
}
