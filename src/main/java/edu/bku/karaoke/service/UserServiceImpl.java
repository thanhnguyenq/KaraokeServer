package edu.bku.karaoke.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import edu.bku.karaoke.Utils;
import edu.bku.karaoke.entity.UserAccount;
import edu.bku.karaoke.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    /** The Constant logger. */
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserRepository userRepository;

    public List<UserAccount> findAll() {
        logger.debug("IN- findAll");
        List<UserAccount> list = userRepository.findAll();

        return list;
    }

    public ResponseEntity<String> login(String json) {
        logger.debug("IN- login");

        JsonNode jsonFile = null;
        try {
            jsonFile = Utils.getJsonNode(json);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("Cannot read json");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        String username = jsonFile.get("username").toString().replaceAll("\"", "");
        String password = jsonFile.get("password").toString().replaceAll("\"", "");

        List<UserAccount> userList = userRepository.getUserByUsernameAndPassword(username, password);
        if (userList.isEmpty() || userList.size() != 1) {
            logger.warn("Not found user");
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        logger.debug("OUT - login()");
        return new ResponseEntity<String>("OK", null, HttpStatus.OK);
    }

    @Override
    public UserAccount findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
