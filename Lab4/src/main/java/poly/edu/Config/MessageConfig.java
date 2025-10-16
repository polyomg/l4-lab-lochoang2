package poly.edu.Config;

import java.time.Duration;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class MessageConfig implements WebMvcConfigurer {

    // Nạp file tài nguyên đa ngôn ngữ (i18n)
    @Bean("messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        // chỉ ra vị trí file i18n/layout.properties, layout_vi.properties
        ms.setBasenames("classpath:i18n/layout");
        ms.setDefaultEncoding("UTF-8"); // xử lý Unicode tiếng Việt
        return ms;
    }

    // Xác định locale mặc định và cách lưu locale (bằng cookie)
    @Bean("localeResolver")
    public LocaleResolver getLocaleResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setCookiePath("/"); // cookie áp dụng cho toàn site
        localeResolver.setCookieMaxAge(Duration.ofDays(30)); // lưu ngôn ngữ 30 ngày
        localeResolver.setDefaultLocale(new Locale("vi")); // mặc định tiếng Việt
        return localeResolver;
    }

    // Cho phép thay đổi ngôn ngữ qua param ?lang=vi hoặc ?lang=en
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang"); // param tên là lang
        registry.addInterceptor(interceptor);
    }
}