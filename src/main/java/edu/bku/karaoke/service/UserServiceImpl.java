package edu.bku.karaoke.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.bku.karaoke.entity.User;
import edu.bku.karaoke.repository.UserRepository;

@Service
public class UserServiceImpl {
    /** The Constant logger. */
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserRepository userRepository;

    public List<User> findAll() {
        logger.debug("IN- findAll");
        List<User> list = userRepository.findAll();

        return list;
    }
}
