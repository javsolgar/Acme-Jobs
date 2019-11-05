
package acme.entities.configuration;

import javax.persistence.Entity;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Configuration extends DomainEntity {

	//Serialization Identify -------------------------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//	Atributes	----------------------------------------------------------------------------------------------------

	private Double				spamThreshold;

	private String				spamWords;

	// Derivated Atributes ---------------------------------------------------------------------------------------------

	/*
	 * @NotBlank
	 * public String getspamWords() {
	 * String res = "";
	 * List<String> lista = new ArrayList<>();
	 * lista.add("sex");
	 * lista.add("hard core");
	 * lista.add("viagra");
	 * lista.add("cialis");
	 * lista.add("nigeria");
	 * lista.add("you've won");
	 * lista.add("million dollar");
	 * for (String i : lista) {
	 * res = res.concat(i);
	 * res = res.concat(",");
	 * }
	 * return res;
	 * }
	 */
}
