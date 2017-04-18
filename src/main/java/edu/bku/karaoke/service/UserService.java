package edu.bku.karaoke.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.bku.karaoke.entity.UserAccount;

public interface UserService {
    public List<UserAccount> findAll();

    public UserAccount findById(Long id);

    public ResponseEntity<String> login(String json);
}
