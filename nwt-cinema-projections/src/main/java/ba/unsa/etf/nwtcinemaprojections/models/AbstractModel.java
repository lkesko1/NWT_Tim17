package ba.unsa.etf.nwtcinemaprojections.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * The abstract model
 */
@MappedSuperclass
public abstract class AbstractModel {

    @Id
    @GeneratedValue
    @NotNull
    @Min(1)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
