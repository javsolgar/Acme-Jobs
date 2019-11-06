
package acme.entities.dashboard;

import java.io.Serializable;

import javax.persistence.Transient;

import acme.features.administrator.dashboard.AdministratorDashboardRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	AdministratorDashboardRepository	repository;

	//Serialization Identify -------------------------------------------------------------------------------------------

	private static final long			serialVersionUID	= 1L;

	//	Atributes	----------------------------------------------------------------------------------------------------

	/*
	 *
	 * private Integer standarDesviationRequest;
	 *
	 * private Integer standarDesviationOffers;
	 */

	// Derivated Atributes -------------------------------------------------------------


	@Transient
	public Integer getTotalAnnouncement() {
		Integer res = this.repository.countAnnouncement();
		return res;
	}

	@Transient
	public Integer getTotalInvestorsRecord() {
		Integer res = this.repository.countInvestorsRecords();
		return res;
	}

	@Transient
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
