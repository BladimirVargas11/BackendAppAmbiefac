package ambiefac.back.data;

import ambiefac.back.domain.entities.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class Role implements CrudRepository<RoleEntity, Long> {

    public Role(){}
    @Override
    public <S extends RoleEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends RoleEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<RoleEntity> findById(Long aLong) {
        return Optional.empty();
    }




    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<RoleEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<RoleEntity> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(RoleEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends RoleEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
