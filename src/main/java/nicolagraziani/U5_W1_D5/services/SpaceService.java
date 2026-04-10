package nicolagraziani.U5_W1_D5.services;

import lombok.extern.slf4j.Slf4j;
import nicolagraziani.U5_W1_D5.entities.Space;
import nicolagraziani.U5_W1_D5.repositories.SpaceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class SpaceService {
    private final SpaceRepository spaceRepository;

    public SpaceService(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    public void saveNewUser(Space newSpace) {
        this.spaceRepository.save(newSpace);
        log.info("Lo spazio {} è stato salvato correttamente", newSpace.getDescription());
    }

    public List<Space> findAllSpaces() {
        return this.spaceRepository.findAll();
    }

    public List<Space> findAllSpacesAvailableByDate(LocalDate date) {
        return this.spaceRepository.findAllSpacesAvailableByDate(date);
    }
}
