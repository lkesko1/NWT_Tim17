package ba.unsa.etf.nwtcinemamovies.controllers;

import ba.unsa.etf.nwtcinemamovies.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController<S extends AbstractService> {
	protected S service;

	@Autowired
	public void setService(S service) {
		this.service = service;
	}
}
