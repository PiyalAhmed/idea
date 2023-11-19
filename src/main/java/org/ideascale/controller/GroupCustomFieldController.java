package org.ideascale.controller;

import org.ideascale.model.GroupCustomField;
import org.ideascale.service.GroupCustomFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class GroupCustomFieldController {
    private final GroupCustomFieldService groupCustomFieldService;

    @Autowired
    public GroupCustomFieldController(GroupCustomFieldService groupCustomFieldService) {
        this.groupCustomFieldService = groupCustomFieldService;
    }

    @RequestMapping(path = "/groupCustomField", method = RequestMethod.POST)
    @ResponseBody
    GroupCustomField addOrUpdateGroupCustomField(@RequestBody GroupCustomField groupCustomField) {
        groupCustomFieldService.addGroupCustomField(groupCustomField);
        return groupCustomField;
    }
    @RequestMapping(path = "/groupCustomField/{id}", method = RequestMethod.GET)
    @ResponseBody
    GroupCustomField getGroupCustomField(@PathVariable Long id) {
        return groupCustomFieldService.getGroupCustomFieldById(id)
                .orElse(new GroupCustomField());
    }
    @RequestMapping(path = "/groupCustomField", method = RequestMethod.GET)
    @ResponseBody
    List<GroupCustomField> getAllGroupCustomFields() {
        return groupCustomFieldService.getAllGroupCustomFields();
    }
    @RequestMapping(path = "/groupCustomField/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    GroupCustomField deleteGroupCustomField(@PathVariable Long id) {
        return groupCustomFieldService.deleteGroupCustomField(id);
    }
}
