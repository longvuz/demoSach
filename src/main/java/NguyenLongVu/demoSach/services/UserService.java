package NguyenLongVu.demoSach.services;

import NguyenLongVu.demoSach.entity.User;
import NguyenLongVu.demoSach.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
}
