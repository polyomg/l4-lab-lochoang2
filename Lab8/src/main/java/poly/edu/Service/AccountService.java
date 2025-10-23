package poly.edu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.Entity.Account;
import poly.edu.dao.AccountDAO;


@Service
public class AccountService {
    @Autowired
    AccountDAO dao;
    public Account findById(String username) {
        return dao.findById(username).orElse(null);
    }
}
