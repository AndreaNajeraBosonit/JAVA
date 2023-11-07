package block7crudvalidation.specs;

import block7crudvalidation.domain.Person;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonaSpecs {


    public PersonaSpecs() {
    }

    public static Specification<Person> filter(String user, String name, String surname,
                                               Date fechaSuperior, Date fechaInferior) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> andPredicates = new ArrayList<>();

            if (user != null){
                andPredicates.add(
                        criteriaBuilder.equal(root.get("usuario"), user)
                );
            }
            if (name != null){
                andPredicates.add(
                        criteriaBuilder.equal(root.get("name"), name)
                );
            }

            if (surname != null){
                andPredicates.add(
                        criteriaBuilder.equal(root.get("surname"), surname)
                );
            }

            if (fechaSuperior != null){
                andPredicates.add(
                        criteriaBuilder.greaterThanOrEqualTo(root.get("created_date"), fechaSuperior)
                );
            }

            if (fechaInferior != null){

                andPredicates.add(
                        criteriaBuilder.lessThanOrEqualTo(root.get("created_date"), fechaInferior)
                );
            }
            return criteriaBuilder.and(andPredicates.toArray(new Predicate[0]));
        };
    }
}
