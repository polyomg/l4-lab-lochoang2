package poly.edu.service;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieService {

    @Autowired
    private ObjectFactory<HttpServletRequest> requestFactory;

    @Autowired
    private ObjectFactory<HttpServletResponse> responseFactory;

    private HttpServletRequest getRequest() {
        return requestFactory.getObject();
    }

    private HttpServletResponse getResponse() {
        return responseFactory.getObject();
    }

    public Cookie get(String name) {
        Cookie[] cookies = getRequest().getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equalsIgnoreCase(name)) return c;
            }
        }
        return null;
    }

    public String getValue(String name) {
        Cookie c = get(name);
        return (c != null) ? c.getValue() : "";
    }

    public Cookie add(String name, String value, int hours) {
        Cookie c = new Cookie(name, value);
        c.setMaxAge(hours * 3600);
        c.setPath("/");
        getResponse().addCookie(c);
        return c;
    }

    public void remove(String name) {
        Cookie c = new Cookie(name, "");
        c.setMaxAge(0);
        c.setPath("/");
        getResponse().addCookie(c);
    }
}
