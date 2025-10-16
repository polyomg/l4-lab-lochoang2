package poly.edu.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    // Trang chủ
    @RequestMapping("/index")
    public String index(Model model) {
        // Nếu muốn gửi dữ liệu ra view, dùng model.addAttribute(...)
        return "/home/index"; // gọi file templates/home/index.html
    }

    // Trang giới thiệu
    @RequestMapping("/about")
    public String about(Model model) {
        return "/home/about"; // gọi file templates/home/about.html
    }
}
