
package acme.features.authenticated.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenge.Challenge;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedChallengeShowService implements AbstractShowService<Authenticated, Challenge> {

	//	Internal State -------------------------------------------------------------------------------------------------------------------
	@Autowired
	AuthenticatedChallengeRepository repository;


	//	AbstractShowService<Authenticated, Challenge> Interface ---------------------------------------------------------------------------------------
	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "deadline", "goalGold", "goalSilver", "goalBronze", "id");

	}

	@Override
	public Challenge findOne(final Request<Challenge> request) {
		assert request != null;
		Integer id = request.getModel().getInteger("id");
		Challenge result = this.repository.findOneById(id);
		return result;
	}

}
