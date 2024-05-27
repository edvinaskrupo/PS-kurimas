package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Car {
    @Id
    private Integer id;

    private String engine;
}
