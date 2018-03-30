package ba.unsa.etf.nwtcinemaprojections.services;

import ba.unsa.etf.nwtcinemaprojections.models.AbstractModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public abstract class BaseService<M extends AbstractModel, R extends JpaRepository<M, Long>> {

    @Autowired
    private R repository;

    public Iterable<M> findAll() {
        return repository.findAll();
    }
    public M findById(Long id) {
        return repository.getOne(id);
    }
    public M add(M m) {
        return repository.save(m);
    }
    public M update(M m) {
        return repository.save(m);
    }
    public void delete(M m) { repository.delete(m); }
}