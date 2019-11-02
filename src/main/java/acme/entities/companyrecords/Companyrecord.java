
package acme.entities.companyrecords;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Companyrecord extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	//Attributes
	@NotBlank
	private String				name;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				ceo;

	@NotBlank
	private String				description;

	@NotBlank
	@URL
	private String				website;

	@NotBlank
	private String				phone;

	@NotBlank
	@Email
	private String				email;

	private Incorporated		incorporated;

	@Min(0)
	@Max(5)
	private Double				stars;


	//Deirvated

	@Transient
	public String getFullName() {

		StringBuilder result;
		result = new StringBuilder();
		result.append(this.name);
		result.append(", ");
		if (this.incorporated == Incorporated.INC) {
			result.append("Inc.");
		} else {
			result.append("LLC");
		}
		return result.toString();
	}

}
