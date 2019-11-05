
package acme.entities.challenge;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge extends DomainEntity {

	//Serialization Identify -------------------------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//	Atributes	----------------------------------------------------------------------------------------------------

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadline;

	@NotBlank
	private String				description;

	@NotBlank
	private String				goldDescription;

	//@NotBlank
	private Integer				goalGold;

	@NotBlank
	private String				silverDescription;

	//@NotBlank
	private Integer				goalSilver;

	@NotBlank
	private String				bronzeDescription;

	//@NotBlank
	private Integer				goalBronze;

}
