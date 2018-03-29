package ba.unsa.etf.nwtcinemareservations.services;

import ba.unsa.etf.nwtcinemareservations.models.AbstractModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public abstract class BaseService<M extends AbstractModel, R extends JpaRepository<M, Long>> {

    @Autowired
    private R repository;

    public Iterable<M> findAll() {
        return repository.findAll();
    }
    public Optional<M> findById(Long id) {
        return repository.findById(id);
    }
    public M add(M m) {
        return repository.save(m);
    }
    public M update(M m) {
        return repository.save(m);
    }
    public void delete(M m) { repository.delete(m); }
}
