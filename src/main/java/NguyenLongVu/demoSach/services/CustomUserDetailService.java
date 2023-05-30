package NguyenLongVu.demoSach.services;
import  NguyenLongVu.demoSach.entity.CustomUserDetail;
import NguyenLongVu.demoSach.entity.User;
import NguyenLongVu.demoSach.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User không tồn tại");
        return new CustomUserDetail(user, userRepository);
    }
}
