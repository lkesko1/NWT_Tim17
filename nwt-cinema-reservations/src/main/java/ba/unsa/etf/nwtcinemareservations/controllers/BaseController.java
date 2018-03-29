package ba.unsa.etf.nwtcinemareservations.controllers;

import ba.unsa.etf.nwtcinemareservations.models.AbstractModel;
import ba.unsa.etf.nwtcinemareservations.services.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;

public abstract class BaseController<S extends BaseService> {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    private S service;

    public S getService() {
        return this.service;
    }

    @Autowired
    public void setService(S service) {
        this.service = service;
    }

    @Transactional
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public AbstractModel create(@RequestBody final AbstractModel model) {
        return service.add(model);
    }


    @Transactional
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Iterable findAll() {
        return service.findAll();
    }

    @Transactional
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public AbstractModel findById(@PathVariable("id") final Long id) {
        return service.findById(id);
    }

    @Transactional
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody final AbstractModel model) {
        service.delete(model);
    }



}
