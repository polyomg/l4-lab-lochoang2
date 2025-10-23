package poly.edu.Model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Staff {

    // Mã nhân viên
    @NotBlank(message = "Chưa nhập mã nhân viên")
    @Size(min = 3, max = 10, message = "Mã nhân viên phải từ 3 đến 10 ký tự")
    private String id;

    // Họ và tên
    @NotBlank(message = "Chưa nhập họ và tên")
    private String fullname;

    // Ảnh đại diện
    @Builder.Default
    private String photo = "photo.jpg";

    // Giới tính
    @NotNull(message = "Chưa chọn giới tính")
    private Boolean gender;

    // Ngày sinh
    @NotNull(message = "Chưa nhập ngày sinh")
    @Past(message = "Ngày sinh không hợp lệ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")  // phù hợp input type="date"
    private Date birthday;

    // Lương
    @NotNull(message = "Chưa nhập lương")
    @Min(value = 1000, message = "Lương tối thiểu phải là 1000")
    private Double salary;

    // Cấp độ (không validation)
    private Integer level;

    // Email
    @NotBlank(message = "Chưa nhập email")
    @Email(message = "Email không đúng định dạng")
    private String email;
}
