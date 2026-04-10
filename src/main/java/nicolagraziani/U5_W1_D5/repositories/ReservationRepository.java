package nicolagraziani.U5_W1_D5.repositories;

import nicolagraziani.U5_W1_D5.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
