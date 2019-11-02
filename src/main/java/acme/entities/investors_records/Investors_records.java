
package acme.entities.investors_records;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;

@Entity
public class Investors_records extends DomainEntity {
	// Serialization Identify ------------------------------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//	Atributes	----------------------------------------------------------------------------------------------------------

	@NotBlank
	private String				name;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				statement;

	private Integer				numberStars;


	// Derivated Atributes -------------------------------------------------------------

	public String getStars() {
		String stars = "";
		if (this.numberStars != null) {
			switch (this.numberStars) {
			case 1:
				stars = "★";
				break;

			case 2:
				stars = "★★";
				break;

			case 3:
				stars = "★★★";
				break;

			case 4:
				stars = "★★★★";
				break;

			case 5:
				stars = "★★★★★";
				break;
			}

		}
		return stars;
	}

}
