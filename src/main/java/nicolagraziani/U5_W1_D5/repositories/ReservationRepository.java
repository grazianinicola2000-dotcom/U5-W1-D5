package nicolagraziani.U5_W1_D5.repositories;

import nicolagraziani.U5_W1_D5.entities.Reservation;
import nicolagraziani.U5_W1_D5.entities.Space;
import nicolagraziani.U5_W1_D5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    boolean existsByUserAndReservationDate(User user, LocalDate reservationDate);

    boolean existsBySpaceAndReservationDate(Space space, LocalDate reservationDate);
}
