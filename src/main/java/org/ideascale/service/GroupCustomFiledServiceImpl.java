package org.ideascale.service;

import org.ideascale.model.GroupCustomField;
import org.ideascale.repository.GroupCustomFieldRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupCustomFiledServiceImpl implements GroupCustomFieldService{
    private final GroupCustomFieldRepo groupCustomFieldRepo;

    @Autowired
    GroupCustomFiledServiceImpl(GroupCustomFieldRepo groupCustomFieldRepo){
        this.groupCustomFieldRepo = groupCustomFieldRepo;
    }
    @Override
    public GroupCustomField addGroupCustomField(GroupCustomField groupCustomField) {
        long sequenceNo = groupCustomFieldRepo.countAllByCommunityId(groupCustomField.getCommunityId());
        groupCustomField.setSequenceNo(++sequenceNo);
        return groupCustomFieldRepo.save(groupCustomField);
    }

    @Override
    public List<GroupCustomField> getAllGroupCustomFields() {
        return groupCustomFieldRepo.findAll();
    }

    @Override
    public Optional<GroupCustomField> getGroupCustomFieldById(Long id) {
        return groupCustomFieldRepo.findByCustomFieldId(id);
    }

    @Override
    public GroupCustomField deleteGroupCustomField(Long id) {
        Optional<GroupCustomField> byCustomFieldId = groupCustomFieldRepo.findByCustomFieldId(id);
        byCustomFieldId.ifPresent(groupCustomFieldRepo::delete);
        return byCustomFieldId.orElseThrow(()->new RuntimeException("group custom field not found"));
    }
}
