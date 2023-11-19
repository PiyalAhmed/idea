package org.ideascale.service;

import org.ideascale.dto.CustomFieldDto;
import org.ideascale.dto.GroupDto;
import org.ideascale.model.*;
import org.ideascale.repository.CommunityRepo;
import org.ideascale.repository.CustomFiledValueRepository;
import org.ideascale.repository.GroupCustomFieldRepo;
import org.ideascale.repository.GroupRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService{
    private final GroupRepo groupRepo;
    private final GroupCustomFieldRepo customFieldRepo;
    private final CommunityRepo communityRepo;
    private final CustomFiledValueRepository valueRepository;
    public GroupServiceImpl(GroupRepo groupRepo, GroupCustomFieldRepo customFieldRepo, CommunityRepo communityRepo, CustomFiledValueRepository valueRepository) {
        this.groupRepo = groupRepo;
        this.customFieldRepo = customFieldRepo;
        this.communityRepo = communityRepo;
        this.valueRepository = valueRepository;
    }


    @Override
    @Transactional
    public GroupDto addGroup(GroupDto groupDto) {

        Community community = communityRepo.findById(groupDto.getCommunityId()).orElseThrow(() -> new RuntimeException("Community doesn't exist"));
        CommunityGroup communityGroup = new CommunityGroup(null, groupDto.getGroupName(),groupDto.getIsPrivate());
        final Long groupId = groupRepo.save(communityGroup).getId();

        community.getCommunityGroups().add(communityGroup);
        communityRepo.save(community);


        List<GroupCustomField> groupCustomFields = groupDto.getCustomFields().stream().map(e->customFieldRepo.findById(e.getCustomFieldId()).orElse(null)).filter(Objects::nonNull).toList();

        List<CustomFiledValue> filedValues = new ArrayList<>();
        groupCustomFields.forEach(field -> {
            GroupCustomFieldType type = field.getType();
            String value = groupDto.getCustomFields().stream().filter(f -> f.getCustomFieldId().equals(field.getCustomFieldId()))
                    .findFirst()
                    .map(CustomFieldDto::getValue)
                    .orElse(null);
            filedValues.add(validateValues(value,type,groupId,field.getCustomFieldId()));
        });
        groupDto.setCustomFields(groupDto.getCustomFields().stream().filter(f -> customFieldRepo.findById(f.getCustomFieldId()).isPresent()).toList());
        valueRepository.saveAll(filedValues);
        return  groupDto;
    }

    private CustomFiledValue validateValues(String value, GroupCustomFieldType type, Long groupId,Long filedId){
        return new CustomFiledValue(null, filedId, groupId, type.equals(GroupCustomFieldType.STRING) ? value : null, type.equals(GroupCustomFieldType.BOOLEAN) ? Boolean.valueOf(value) : null);
    }

    @Override
    public List<CommunityGroup> getAllGroups() {
        return groupRepo.findAll();
    }

    @Override
    public Optional<CommunityGroup> getGroup(Long id) {
        return groupRepo.findById(id);
    }

    @Override
    public CommunityGroup deleteGroup(Long id) {
        CommunityGroup communityGroup = groupRepo.findById(id).orElseThrow(() -> new RuntimeException("groupNotFound"));
        groupRepo.delete(communityGroup);
        return communityGroup;
    }
}
