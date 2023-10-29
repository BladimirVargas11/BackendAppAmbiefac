package ambiefac.back.domain.entities;

import ambiefac.back.domain.enums.RoleId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
public class RoleEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Enumerated(EnumType.STRING)
    private RoleId id;
    private  String name;
}
