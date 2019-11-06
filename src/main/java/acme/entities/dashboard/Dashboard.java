
package acme.entities.dashboard;

import javax.persistence.Entity;
import javax.persistence.Transient;

import acme.features.administrator.dashboard.AdministratorDashboardRepository;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Dashboard extends DomainEntity {

	AdministratorDashboardRepository	repository;

	//Serialization Identify -------------------------------------------------------------------------------------------

	private static final long			serialVersionUID	= 1L;

	//	Atributes	----------------------------------------------------------------------------------------------------

	/*
	 * private Integer totalAnnouncement;
	 *
	 * private Integer totalInverstors;
	 *
	 * private Integer totalCompany;
	 *
	 * private Integer minimunRequest;
	 *
	 * private Integer maximunRequest;
	 *
	 * private Integer standarDesviationRequest;
	 *
	 * private Integer minimunOffers;
	 *
	 * private Integer maximunOffers;
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

	@Transient
	public Money getMinRewardRequest() {
		Money res = this.repository.getMinRewardRequest();
		return res;
	}

	@Transient
	public Money getMaxRewardRequest() {
		Money res = this.repository.getMaxRewardRequest();
		return res;
	}

	@Transient
	public Money getMinRewardOffer() {
		Money res = this.repository.getMinRewardOffer();
		return res;
	}

	@Transient
	public Money getMaxRewardOffer() {
		Money res = this.repository.getMaxRewardOffer();
		return res;
	}

}
