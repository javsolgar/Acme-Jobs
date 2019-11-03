
package acme.entities.configuration;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

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

	@ElementCollection(targetClass = String.class)
	private Collection<String>	spamWords;

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
	@Transient
	@Min(0)
	public Integer getMenorQue0() {
		Integer res = -1;
		if (this.spamThreshold != null && this.spamThreshold >= 0.0) {
			res = new Integer(this.spamThreshold.intValue());
		}
		return res;
	}
}
