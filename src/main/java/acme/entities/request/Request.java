
package acme.entities.request;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Request extends DomainEntity {

	// Serialization Identify ------------------------------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//	Atributes	----------------------------------------------------------------------------------------------------------

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadLine;

	@NotBlank
	private String				description;

	//@NotBlank
	//@Min(0)
	private Money				reward;

	@NotBlank
	//@Pattern("([R]{1})([A-Z]{})([-])([0-9]{5})")
	private String				idRequest;

}
