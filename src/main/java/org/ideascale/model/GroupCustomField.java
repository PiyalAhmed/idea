package org.ideascale.model;

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
public class GroupCustomField {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customFieldId;
    private Long communityId;
    private String label;
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isRequired;
    private Long sequenceNo;
    @Enumerated(EnumType.STRING)
    private GroupCustomFieldType type;
}