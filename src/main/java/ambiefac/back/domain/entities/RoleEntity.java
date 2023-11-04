package ambiefac.back.domain.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class RoleEntity {
    @Id
    private int id;
    private  String name;

    public RoleEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
