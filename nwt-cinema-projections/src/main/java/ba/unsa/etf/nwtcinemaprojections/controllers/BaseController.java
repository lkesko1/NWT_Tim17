package ba.unsa.etf.nwtcinemaprojections.controllers;

import ba.unsa.etf.nwtcinemaprojections.models.AbstractModel;
import ba.unsa.etf.nwtcinemaprojections.services.BaseService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class BaseController<M extends AbstractModel, S extends BaseService> {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected S service;

    @Transactional
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody final M model) {/*, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return model;
        }*/
        M response = (M)service.add(model);
        if (response == null) {
//            String errorMsg = "Something went wrong"; //toJSon
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    @Transactional
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Iterable findAll() {
        return service.findAll();
    }

    @Transactional
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Optional<M> findById(@PathVariable("id") final Long id) {
        return service.findById(id);
    }

    @Transactional
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody @Valid @ModelAttribute("M") final M model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return;
        }
        service.delete(model);
    }

}