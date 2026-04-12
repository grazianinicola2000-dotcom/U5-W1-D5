package nicolagraziani.U5_W1_D5.repositories;

import nicolagraziani.U5_W1_D5.entities.Space;
import nicolagraziani.U5_W1_D5.enums.SpaceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SpaceRepository extends JpaRepository<Space, Long> {

    // QUERY PER TROVARE TUTTI GLI SPAZI CHE NON HANNO UNA PRENOTAZIONE IN UNA DETERMINATA DATA
    @Query("SELECT s FROM Space s WHERE NOT EXISTS (SELECT r FROM Reservation r WHERE r.space = s AND r.reservationDate = :date)")
    List<Space> findAllSpacesAvailableByDate(@Param("date") LocalDate date);

    @Query("SELECT s FROM Space s WHERE LOWER(s.building.city) = LOWER(:city) AND s.type = :type")
    List<Space> findByCityAndType(@Param("city") String city, @Param("type") SpaceType type);
}
