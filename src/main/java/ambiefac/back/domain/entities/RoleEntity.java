package ambiefac.back.domain.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class RoleEntity {
    @Id
    @NotNull
    private int id;
    
    @NotBlank
    private  String name;
    


    public RoleEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
