package org.ideascale.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.NumericBooleanConverter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CommunityGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isPrivate;
}
