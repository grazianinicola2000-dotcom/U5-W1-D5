package nicolagraziani.U5_W1_D5.services;

import lombok.extern.slf4j.Slf4j;
import nicolagraziani.U5_W1_D5.entities.Building;
import nicolagraziani.U5_W1_D5.exceptions.BuildingValidationException;
import nicolagraziani.U5_W1_D5.exceptions.IdNotFoundException;
import nicolagraziani.U5_W1_D5.repositories.BuildingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BuildingService {
    private final BuildingRepository buildingRepository;

    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public void saveNewBuilding(Building newBuilding) {
//        CONTROLLO SU INDIRIZZO
        if (this.buildingRepository.existsByAddress(newBuilding.getAddress()))
            throw new BuildingValidationException("Il Building all'indirizzo " + newBuilding.getAddress() + " è già registrato");
//        CONTROLLO SUL NOME
        if (this.buildingRepository.existsByName(newBuilding.getName()))
            throw new BuildingValidationException("Il Nome " + newBuilding.getName() + " è già registrato");

        this.buildingRepository.save(newBuilding);

        log.info("Il Building {} è stato registrato correttamente", newBuilding.getName());
    }

    public Building findById(Long buildingId) {
        Optional<Building> found = this.buildingRepository.findById(buildingId);
        if (found.isPresent()) {
            log.info("Risultato ricerca: ");
            log.info(found.get().toString());
            return found.get();
        } else throw new IdNotFoundException(buildingId);
    }

    public void findByIdAndDelete(long buildingId) {
        Building found = this.findById(buildingId);
        this.buildingRepository.delete(found);
        log.info("Il Building {} è stato eliminato con successo", found.getName());
    }
}
