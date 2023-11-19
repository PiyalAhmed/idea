package org.ideascale.controller;

import org.ideascale.model.Community;
import org.ideascale.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class CommunityController {
    private final CommunityService communityService;
    

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @RequestMapping(path = "/community", method = RequestMethod.POST)
    @ResponseBody
    Community addOrUpdateCommunity(@RequestBody Community community) {
        communityService.addCommunity(community);
        return community;
    }
    @RequestMapping(path = "/community/{id}", method = RequestMethod.GET)
    @ResponseBody
    Community getCommunity(@PathVariable Long id) {
        return communityService.getCommunity(id).orElse( new Community());
    }
    @RequestMapping(path = "/community", method = RequestMethod.GET)
    @ResponseBody
    List<Community> getAllCommunity() {
        return communityService.getAllcommunities();
    }
    @RequestMapping(path = "/community/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    Community deleteCommunity(@PathVariable Long id) {
        return communityService.deleteCommunity(id);
    }
}
