package nicolagraziani.U5_W1_D5.services;

import lombok.extern.slf4j.Slf4j;
import nicolagraziani.U5_W1_D5.entities.User;
import nicolagraziani.U5_W1_D5.exceptions.IdNotFoundException;
import nicolagraziani.U5_W1_D5.exceptions.UserValidationException;
import nicolagraziani.U5_W1_D5.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveNewUser(User newUser) {
//        CONTROLLO E-MAIL
        if (this.userRepository.existsByEmail(newUser.getEmail()))
            throw new UserValidationException("L'Email " + newUser.getEmail() + " è già in uso");
//        CONTROLLO USERNAME
        if (newUser.getUsername().length() < 5)
            throw new UserValidationException("L'Username " + newUser.getUsername() + " è troppo corto, deve essere almeno di 5 caratteri");
        if (this.userRepository.existsByUsername(newUser.getUsername()))
            throw new UserValidationException("L'Username " + newUser.getUsername() + " è già in uso");

        this.userRepository.save(newUser);

        log.info("L'Utente {} {} è stato salvato correttamente", newUser.getSurname(), newUser.getName());
    }

    public User findById(Long userId) {
        Optional<User> found = this.userRepository.findById(userId);
        if (found.isPresent()) {
            log.info("Risultato ricerca: ");
            log.info(found.get().toString());
            return found.get();
        } else throw new IdNotFoundException(userId);
    }


    public void findByIdAndDelete(long userId) {
        User found = this.findById(userId);
        this.userRepository.delete(found);
        log.info("L'utente {}{} è stato eliminato correttamente", found.getName(), found.getUsername());
    }
}
