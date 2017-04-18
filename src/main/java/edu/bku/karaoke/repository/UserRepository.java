package edu.bku.karaoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bku.karaoke.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
