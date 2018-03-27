package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.services.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController<S extends AbstractService> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected S service;

	@Autowired
	public void setService(S service) {
		this.service = service;
	}
}
