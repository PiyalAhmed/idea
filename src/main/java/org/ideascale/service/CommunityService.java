package org.ideascale.service;

import org.ideascale.model.Community;

import java.util.List;
import java.util.Optional;

public interface CommunityService {
    Community addCommunity(Community communityService);
    List<Community> getAllcommunities();
    Optional<Community> getCommunity(Long id);
    Community deleteCommunity(Long id);
}
