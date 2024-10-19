package pl.jaroslaw.bybetterperson.api.organization.query;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jaroslaw.bybetterperson.api.organization.query.dto.OrganizationDto;

@RestController
@AllArgsConstructor
@RequestMapping("/api/organization")
public class OrganizationQueryController {

    private final GetOrganizationByIdQuery getOrganizationByIdQuery;

    @GetMapping("/{id}")
    OrganizationDto getOrganizationById(@PathVariable Long id){
        return getOrganizationByIdQuery.handle(id);
    }
}
