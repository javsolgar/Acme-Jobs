
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dashboard.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AdministratorDashboardRepository repository;


	// AbstractShowService<Administrator, Dashboard> interface --------------

	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalAnnouncment", "totalInvestorsRecord", "totalCompanyRecords");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		Dashboard result = new Dashboard();
		result.setTotalAnnouncement(this.getTotalAnnouncement());
		result.setTotalCompanyRecord(this.getTotalCompanyRecord());
		result.setTotalInvestorsRecord(this.getTotalInvestorsRecord());
		return result;
	}

	public Integer getTotalAnnouncement() {
		Integer res = this.repository.countAnnouncement();
		return res;
	}

	public Integer getTotalInvestorsRecord() {
		Integer res = this.repository.countInvestorsRecords();
		return res;
	}

	public Integer getTotalCompanyRecord() {
		Integer res = this.repository.countCompanyRecord();
		return res;
	}

	/*
	 * @Transient
	 * public Money getMinRewardRequest() {
	 * Money res = this.repository.getMinRewardRequest();
	 * return res;
	 * }
	 *
	 * @Transient
	 * public Money getMaxRewardRequest() {
	 * Money res = this.repository.getMaxRewardRequest();
	 * return res;
	 * }
	 *
	 * @Transient
	 * public Money getMinRewardOffer() {
	 * Money res = this.repository.getMinRewardOffer();
	 * return res;
	 * }
	 *
	 * @Transient
	 * public Money getMaxRewardOffer() {
	 * Money res = this.repository.getMaxRewardOffer();
	 * return res;
	 * }
	 */

}
