package org.ideascale.service;

import org.ideascale.model.GroupCustomField;

import java.util.List;
import java.util.Optional;

public interface GroupCustomFieldService {
    GroupCustomField addGroupCustomField(GroupCustomField groupCustomField);
    List<GroupCustomField> getAllGroupCustomFields();
    Optional<GroupCustomField> getGroupCustomFieldById(Long id);
    GroupCustomField deleteGroupCustomField(Long id);
}
