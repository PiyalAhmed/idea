package org.ideascale.service;

import org.ideascale.model.Community;
import org.ideascale.repository.CommunityRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityServiceImpl implements CommunityService{
    private final CommunityRepo communityRepo;

    public CommunityServiceImpl(CommunityRepo communityRepo) {
        this.communityRepo = communityRepo;
    }

    @Override
    public Community addCommunity(Community communityService) {
        return communityRepo.save(communityService);
    }

    @Override
    public List<Community> getAllcommunities() {
        return communityRepo.findAll();
    }

    @Override
    public Optional<Community> getCommunity(Long id) {
        return communityRepo.findById(id);
    }

    @Override
    public Community deleteCommunity(Long id) {
        Optional<Community> community = communityRepo.findById(id);
        community.ifPresent(communityRepo::delete);
        return community.orElseThrow(() -> new RuntimeException("Community doesn't exist"));
    }
}
