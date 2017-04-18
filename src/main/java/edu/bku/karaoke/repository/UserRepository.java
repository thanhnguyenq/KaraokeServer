package edu.bku.karaoke.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.bku.karaoke.entity.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {
    
    @Transactional
    @Query(value = "SELECT o FROM UserAccount o WHERE o.username = :username AND o.password = :password")
    public List<UserAccount> getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
