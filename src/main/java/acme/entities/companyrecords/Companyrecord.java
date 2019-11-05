
package acme.entities.companyrecords;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

	@NotNull
	private Boolean				incorporated;

	@Min(0)
	@Max(5)
	private Integer				numberStars;

	//Deirvated


	public String getNumberStars() {
		String stars = "";
		if (this.numberStars != null) {
			switch (this.numberStars) {
			case 0:
				stars = "-";
				break;

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
