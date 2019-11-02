
package acme.features.authenticated.offers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offers;
import acme.framework.components.Model;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedOffersShowService implements AbstractShowService<Authenticated, Offers> {

	//	 Internal  state	-------------------------------------------------------------------------
	@Autowired
	private AuthenticatedOffersRepository repository;


	//	AbstractShowService<Authenticated, Request> Interface --------------------------------------

	@Override
	public boolean authorise(final acme.framework.components.Request<Offers> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final acme.framework.components.Request<Offers> request, final Offers entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "description", "lowerRange", "majorRange", "moment", "deadline", "idOffers");
	}

	@Override
	public Offers findOne(final acme.framework.components.Request<Offers> request) {
		assert request != null;

		Offers result;

		Integer id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
