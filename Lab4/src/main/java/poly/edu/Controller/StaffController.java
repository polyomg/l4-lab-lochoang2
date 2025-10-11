package poly.edu.Controller;
import jakarta.validation.*;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.Model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class StaffController {
    @RequestMapping("/poly/form")
    public String createForm(Model model, @ModelAttribute("staff") Staff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "form";
    }

    @PostMapping("/staff/create/save")
    public String createSave(
            Model model,
            @Valid @ModelAttribute("staff") Staff staff,
            Errors errors,
            @RequestPart("photo_file") MultipartFile photoFile) {

        // Nếu có upload file thì set tên file
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
        }

        return "form";
    }
}
