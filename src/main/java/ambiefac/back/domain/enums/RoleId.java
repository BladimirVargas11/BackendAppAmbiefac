package ambiefac.back.domain.enums;

import java.util.Arrays;
import java.util.List;

public enum RoleId {

    ADMIN(1L),
    USER(2L);

    private final Long id;

    RoleId(Long id){
        this.id = id;
    }

    public Long getId(){
        return  id;
    }

    public static List<Long> getAllIds() {
        return Arrays.asList(ADMIN.getId(), USER.getId());
    }

}
