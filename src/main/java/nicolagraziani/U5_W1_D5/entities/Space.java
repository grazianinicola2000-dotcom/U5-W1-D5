package nicolagraziani.U5_W1_D5.entities;

import jakarta.persistence.*;
import lombok.*;
import nicolagraziani.U5_W1_D5.enums.SpaceType;

import java.util.List;

@Entity
@Table(name = "spaces")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "space_id")
    private long spaceId;

    @Column(nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SpaceType type;
    @Column(nullable = false, name = "max_people")
    private int maxPeople;
    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;
    @OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Space(String description, SpaceType type, int maxPeople, Building building) {
        this.description = description;
        this.type = type;
        this.maxPeople = maxPeople;
        this.building = building;
    }
}
