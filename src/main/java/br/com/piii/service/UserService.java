package br.com.piii.service;

import br.com.piii.model.User;
import br.com.piii.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Transactional
    public boolean save(User user){
        try {
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findAllMunicipes() {
        List<User> user = userRepository.findAll().stream().filter(key -> key.getRole().getId() == 0).collect(Collectors.toList());
        return user;
    }

    public List<User> findAllAgentes() {
        List<User> user = userRepository.findAll().stream().filter(key -> key.getRole().getId() != 0).collect(Collectors.toList());
        return user;
    }

    public User findById(int id) {
        return userRepository.findOne(id);
    }

    public boolean deleteById(int idUser) {
        try {
            userRepository.delete(idUser);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
