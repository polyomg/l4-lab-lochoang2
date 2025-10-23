package poly.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.edu.Entity.Account;

@Repository

public interface AccountDAO extends JpaRepository<Account, String> {

}