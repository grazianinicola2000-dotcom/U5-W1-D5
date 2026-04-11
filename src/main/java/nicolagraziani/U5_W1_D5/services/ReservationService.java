package nicolagraziani.U5_W1_D5.services;

import lombok.extern.slf4j.Slf4j;
import nicolagraziani.U5_W1_D5.entities.Reservation;
import nicolagraziani.U5_W1_D5.entities.Space;
import nicolagraziani.U5_W1_D5.entities.User;
import nicolagraziani.U5_W1_D5.exceptions.ReservationValidationException;
import nicolagraziani.U5_W1_D5.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    private void saveNewReservation(Reservation newReservation) {
        if (this.reservationRepository.existsByUserAndReservationDate(newReservation.getUser(), newReservation.getReservationDate())) {
            throw new ReservationValidationException("La prenotazione per l'utente " + newReservation.getUser().getUsername() + " nella data " + newReservation.getReservationDate() + " è già registrata!");
        }
        if (this.reservationRepository.existsBySpaceAndReservationDate(newReservation.getSpace(), newReservation.getReservationDate())) {
            throw new ReservationValidationException("Lo spazio " + newReservation.getSpace().getDescription() + " nella data " + newReservation.getReservationDate() + " è già prenotato!");
        }

        this.reservationRepository.save(newReservation);

        log.info("La prenotazione per lo spazio {} nel giorno {} a nome di {} {} è stata effettuata con successo",
                newReservation.getSpace().getSpaceId(),
                newReservation.getReservationDate(),
                newReservation.getUser().getSurname(),
                newReservation.getUser().getName());
    }

    public void registerNewReservation(User user, Space space, LocalDate date) {
        Reservation r = new Reservation(date, user, space);
        try {
            this.saveNewReservation(r);
        } catch (ReservationValidationException e) {
            log.warn(e.getMessage());
            throw e;
        }
    }
}
