package nicolagraziani.U5_W1_D5.services;

import lombok.extern.slf4j.Slf4j;
import nicolagraziani.U5_W1_D5.entities.Reservation;
import nicolagraziani.U5_W1_D5.exceptions.ReservationValidationException;
import nicolagraziani.U5_W1_D5.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void saveNewReservation(Reservation newReservation) {
        if (this.reservationRepository.existsByUserAndReservationDate(newReservation.getUser(), newReservation.getReservationDate())) {
            throw new ReservationValidationException("La prenotazione per l'utente " + newReservation.getUser().getUsername() + " nella data " + newReservation.getReservationDate() + " è già registrata!");
        }

        this.reservationRepository.save(newReservation);

        log.info("La prenotazione per lo spazio {} nel giorno {} a nome di {} è stata effettuata con successo", newReservation.getSpace().getSpaceId(), newReservation.getReservationDate(), newReservation.getUser().getName());
    }
}
