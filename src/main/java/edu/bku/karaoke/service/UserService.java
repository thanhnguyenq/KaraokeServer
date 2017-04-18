package edu.bku.karaoke.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.bku.karaoke.entity.User;

public interface UserService {
    public List<User> findAll();

    public User findById(Long id);

    public ResponseEntity<User> postISO8601(String json);

    public ResponseEntity<User> putISO8601(Long id, String json);
}
