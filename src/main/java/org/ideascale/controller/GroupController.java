package org.ideascale.controller;

import org.ideascale.dto.GroupDto;
import org.ideascale.model.CommunityGroup;
import org.ideascale.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class GroupController {
    private final GroupService groupService;


    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(path = "/group", method = RequestMethod.POST)
    @ResponseBody
    GroupDto addOrUpdateGroup(@RequestBody GroupDto dto) {
        groupService.addGroup(dto);
        return dto;
    }
    @RequestMapping(path = "/group/{id}", method = RequestMethod.GET)
    @ResponseBody
    CommunityGroup getGroup(@PathVariable Long id) {
        return groupService.getGroup(id).orElse( new CommunityGroup());
    }
    @RequestMapping(path = "/group", method = RequestMethod.GET)
    @ResponseBody
    List<CommunityGroup> getAllGroup() {
        return groupService.getAllGroups();
    }
    @RequestMapping(path = "/group/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    CommunityGroup deleteGroup(@PathVariable Long id) {
        return groupService.deleteGroup(id);
    }
}
