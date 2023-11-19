package org.ideascale.service;

import org.ideascale.dto.GroupDto;
import org.ideascale.model.CommunityGroup;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    GroupDto addGroup(GroupDto communityGroup);
    List<CommunityGroup> getAllGroups();
    Optional<CommunityGroup> getGroup(Long id);
    CommunityGroup deleteGroup(Long id);
}
