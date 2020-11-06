package lt.auba.getadvice.service;

import lt.auba.getadvice.model.User;
import lt.auba.getadvice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public void saveUserData(User user){
        userRepository.save(user);
    }

    public Long getUserId(long id) {
        Long userId;
            //Optional object???
            Optional<User> optional = userRepository.findById(id);
            User user = null;
            if(optional.isPresent()) {
                user = optional.get();
                userId = user.getUserId();
            }else {
                throw new RuntimeException("User with id ::" + id + " not found!");
            }
            return userId;

    }

}
