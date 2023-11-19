package org.ideascale.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    String groupName;
    Boolean isPrivate;
    Long communityId;
    List<CustomFieldDto> customFields;
}
