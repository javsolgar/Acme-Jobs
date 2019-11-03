
package acme.features.authenticated.offers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offers;
import acme.framework.components.Model;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedOffersListService implements AbstractListService<Authenticated, Offers> {

	//	 Internal  state	-------------------------------------------------------------------------

	@Autowired
	AuthenticatedOffersRepository repository;


	//	AbstractListService<Authenticated, Offers> interface ----------------------------------

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
	public Collection<Offers> findMany(final acme.framework.components.Request<Offers> request) {
		assert request != null;

		Collection<Offers> result;

		result = this.repository.findManyAll();

		return result;
	}

}
