package nicolagraziani.U5_W1_D5.runners;

import lombok.extern.slf4j.Slf4j;
import nicolagraziani.U5_W1_D5.entities.Space;
import nicolagraziani.U5_W1_D5.services.BuildingService;
import nicolagraziani.U5_W1_D5.services.ReservationService;
import nicolagraziani.U5_W1_D5.services.SpaceService;
import nicolagraziani.U5_W1_D5.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
public class Runner implements CommandLineRunner {

    private final BuildingService buildingService;
    private final UserService userService;
    private final SpaceService spaceService;
    private final ReservationService reservationService;

    public Runner(BuildingService buildingService, UserService userService, SpaceService spaceService, ReservationService reservationService) {
        this.buildingService = buildingService;
        this.reservationService = reservationService;
        this.spaceService = spaceService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

//        Building b1 = new Building("Sede Milano Centro", "Via Roma 1", "Milano");
//        Building b2 = new Building("Sede Torino Lingotto", "Via Torino 45", "Torino");
//        Building b3 = new Building("Sede Roma EUR", "Viale Europa 100", "Roma");
//
//        buildingService.saveNewBuilding(b1);
//        buildingService.saveNewBuilding(b2);
//        buildingService.saveNewBuilding(b3);
//
//        Space s1 = new Space("Open space 12 posti - Milano", SpaceType.OPEN_SPACE, 12, b1);
//        Space s2 = new Space("Ufficio privato 2 posti - Milano", SpaceType.PRIVATO, 2, b1);
//        Space s3 = new Space("Sala riunioni 6 posti - Milano", SpaceType.SALA_RIUNIONI, 6, b1);
//        Space s4 = new Space("Open space 15 posti - Milano", SpaceType.OPEN_SPACE, 15, b1);
//        Space s5 = new Space("Ufficio privato 2 posti - Milano", SpaceType.PRIVATO, 2, b1);
//        Space s6 = new Space("Sala riunioni 8 posti - Milano", SpaceType.SALA_RIUNIONI, 8, b1);
//        Space s7 = new Space("Open space 10 posti - Milano", SpaceType.OPEN_SPACE, 10, b1);
//        Space s8 = new Space("Ufficio privato 3 posti - Milano", SpaceType.PRIVATO, 3, b1);
//        Space s9 = new Space("Sala riunioni 5 posti - Milano", SpaceType.SALA_RIUNIONI, 5, b1);
//        Space s10 = new Space("Open space 20 posti - Milano", SpaceType.OPEN_SPACE, 20, b1);
//        Space s11 = new Space("Open space 10 posti - Torino", SpaceType.OPEN_SPACE, 10, b2);
//        Space s12 = new Space("Ufficio privato 2 posti - Torino", SpaceType.PRIVATO, 2, b2);
//        Space s13 = new Space("Sala riunioni 4 posti - Torino", SpaceType.SALA_RIUNIONI, 4, b2);
//        Space s14 = new Space("Open space 18 posti - Torino", SpaceType.OPEN_SPACE, 18, b2);
//        Space s15 = new Space("Ufficio privato 3 posti - Torino", SpaceType.PRIVATO, 3, b2);
//        Space s16 = new Space("Sala riunioni 10 posti - Torino", SpaceType.SALA_RIUNIONI, 10, b2);
//        Space s17 = new Space("Open space 14 posti - Torino", SpaceType.OPEN_SPACE, 14, b2);
//        Space s18 = new Space("Ufficio privato 2 posti - Torino", SpaceType.PRIVATO, 2, b2);
//        Space s19 = new Space("Sala riunioni 6 posti - Torino", SpaceType.SALA_RIUNIONI, 6, b2);
//        Space s20 = new Space("Open space 22 posti - Torino", SpaceType.OPEN_SPACE, 22, b2);
//        Space s21 = new Space("Open space 16 posti - Roma", SpaceType.OPEN_SPACE, 16, b3);
//        Space s22 = new Space("Ufficio privato 2 posti - Roma", SpaceType.PRIVATO, 2, b3);
//        Space s23 = new Space("Sala riunioni 8 posti - Roma", SpaceType.SALA_RIUNIONI, 8, b3);
//        Space s24 = new Space("Open space 20 posti - Roma", SpaceType.OPEN_SPACE, 20, b3);
//        Space s25 = new Space("Ufficio privato 3 posti - Roma", SpaceType.PRIVATO, 3, b3);
//        Space s26 = new Space("Sala riunioni 12 posti - Roma", SpaceType.SALA_RIUNIONI, 12, b3);
//        Space s27 = new Space("Open space 9 posti - Roma", SpaceType.OPEN_SPACE, 9, b3);
//        Space s28 = new Space("Ufficio privato 2 posti - Roma", SpaceType.PRIVATO, 2, b3);
//        Space s29 = new Space("Sala riunioni 5 posti - Roma", SpaceType.SALA_RIUNIONI, 5, b3);
//        Space s30 = new Space("Open space 25 posti - Roma", SpaceType.OPEN_SPACE, 25, b3);
//
//        spaceService.saveNewSpace(s1);
//        spaceService.saveNewSpace(s2);
//        spaceService.saveNewSpace(s3);
//        spaceService.saveNewSpace(s4);
//        spaceService.saveNewSpace(s5);
//        spaceService.saveNewSpace(s6);
//        spaceService.saveNewSpace(s7);
//        spaceService.saveNewSpace(s8);
//        spaceService.saveNewSpace(s9);
//        spaceService.saveNewSpace(s10);
//        spaceService.saveNewSpace(s11);
//        spaceService.saveNewSpace(s12);
//        spaceService.saveNewSpace(s13);
//        spaceService.saveNewSpace(s14);
//        spaceService.saveNewSpace(s15);
//        spaceService.saveNewSpace(s16);
//        spaceService.saveNewSpace(s17);
//        spaceService.saveNewSpace(s18);
//        spaceService.saveNewSpace(s19);
//        spaceService.saveNewSpace(s20);
//        spaceService.saveNewSpace(s21);
//        spaceService.saveNewSpace(s22);
//        spaceService.saveNewSpace(s23);
//        spaceService.saveNewSpace(s24);
//        spaceService.saveNewSpace(s25);
//        spaceService.saveNewSpace(s26);
//        spaceService.saveNewSpace(s27);
//        spaceService.saveNewSpace(s28);
//        spaceService.saveNewSpace(s29);
//        spaceService.saveNewSpace(s30);

//        User u1 = new User("m.rossi@email.com", "Rossi", "Mario", "mrossi");
//        User u2 = new User("l.bianchi@email.com", "Bianchi", "Luca", "lbianchi");
//        User u3 = new User("g.verdi@email.com", "Verdi", "Giulia", "gverdi");
//        User u4 = new User("a.neri@email.com", "Neri", "Alessandro", "aneri");
//        User u5 = new User("s.ferrari@email.com", "Ferrari", "Sara", "sferrari");
//
//        userService.saveNewUser(u1);
//        userService.saveNewUser(u2);
//        userService.saveNewUser(u3);
//        userService.saveNewUser(u4);
//        userService.saveNewUser(u5);

//        try {
////            reservationService.registerNewReservation(userService.findById(1), spaceService.findById(1), LocalDate.of(2026, 04, 12));
//
//            reservationService.registerNewReservation(userService.findById(2), spaceService.findById(2), LocalDate.of(2026, 04, 12));
//            reservationService.registerNewReservation(userService.findById(3), spaceService.findById(3), LocalDate.of(2026, 04, 12));
//            reservationService.registerNewReservation(userService.findById(4), spaceService.findById(4), LocalDate.of(2026, 04, 12));
//        } catch (ReservationValidationException e) {
//            log.warn("Impossibile aggiungere la prenotazione: {}", e.getMessage());
//        }

        List<Space> spaces = spaceService.findAllSpacesAvailableByDate(LocalDate.of(2026, 04, 12));
        spaces.forEach(System.out::println);
    }
}
