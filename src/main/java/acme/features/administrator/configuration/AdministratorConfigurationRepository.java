
package acme.features.administrator.configuration;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configuration.Configuration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorConfigurationRepository extends AbstractRepository {

	@Query("select a from Configuration a where a.id=6")
	Configuration findConfiguration();

	@Query("select a from Configuration a ")
	Collection<Configuration> findAllConfiguration();

}
