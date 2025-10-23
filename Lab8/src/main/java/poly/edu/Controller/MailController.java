package poly.edu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.Service.MailService;
import poly.edu.Service.MailService.Mail;

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("mail", new Mail());
        return "mail";
    }

    @PostMapping("/send")
    public String sendMail(@ModelAttribute Mail mail,
                           @RequestParam("action") String action,
                           Model model) {
        try {
            if ("send".equals(action)) {
                mailService.send(mail);
                model.addAttribute("message", "📩 Mail đã được gửi thành công!");
            } else if ("queue".equals(action)) {
                mailService.push(mail);
                model.addAttribute("message", "🕒 Mail đã được thêm vào hàng đợi!");
            }
        } catch (Exception e) {
            model.addAttribute("message", "⚠️ Lỗi khi gửi mail: " + e.getMessage());
        }
        return "mail";
    }
}