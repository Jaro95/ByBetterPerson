package pl.jaroslaw.bybetterperson.domain.address;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jaroslaw.bybetterperson.domain.address.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
