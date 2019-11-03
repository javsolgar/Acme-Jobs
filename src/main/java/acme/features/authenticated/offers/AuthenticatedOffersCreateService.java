
package acme.features.authenticated.offers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offers;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedOffersCreateService implements AbstractCreateService<Consumer, Offers> {

	//	Internal State ---------------------------------------------------------------------------------------
	@Autowired
	AuthenticatedOffersRepository repository;

	// AbstractCreateService<Consumer, Offers> Interface-----------------------------------------------------


	@Override
	public boolean authorise(final acme.framework.components.Request<Offers> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final acme.framework.components.Request<Offers> request, final Offers entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors);
	}

	@Override
	public void unbind(final acme.framework.components.Request<Offers> request, final Offers entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "description", "lowerRange", "majorRange", "moment", "deadline", "idOffers");
	}

	@Override
	public Offers instantiate(final acme.framework.components.Request<Offers> request) {
		assert request != null;

		Offers result;
		Date moment;
		Money lower = new Money();
		lower.setAmount(200.0);
		lower.setCurrency("€");
		Money major = new Money();
		major.setAmount(200.0);
		major.setCurrency("€");

		moment = new Date(System.currentTimeMillis() - 1);
		result = new Offers();
		result.setTitle("Title");
		result.setDescription("Description");
		result.setLowerRange(lower);
		result.setMajorRange(major);
		result.setMoment(moment);
		result.setDeadline(moment);

		return result;
	}

	@Override
	public void validate(final acme.framework.components.Request<Offers> request, final Offers entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final acme.framework.components.Request<Offers> request, final Offers entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
