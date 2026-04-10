package nicolagraziani.U5_W1_D5.repositories;

import nicolagraziani.U5_W1_D5.entities.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SpaceRepository extends JpaRepository<Space, Long> {

    // QUERY PER TROVARE TUTTI GLI SPAZI CHE NON HANNO UNA PRENOTAZIONE IN UNA DETERMINATA DATA
    @Query("SELECT s FROM Space s WHERE NOT EXISTS (SELECT r FROM Reservation r WHERE r.space = s AND r.reservationDate = : date)")
    List<Space> findAllSpacesAvailableByDate(LocalDate date);
}
