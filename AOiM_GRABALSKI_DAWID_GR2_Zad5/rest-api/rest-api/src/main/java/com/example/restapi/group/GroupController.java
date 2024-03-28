package com.example.restapi.group;

import com.example.restapi.emp.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/group")
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<GroupEmployee> getGroups(){
        return groupService.getGroups();
    }

    @PostMapping
    public void registerGroup(@RequestBody GroupEmployee group) {
        groupService.addGroup(group);
    }

    @DeleteMapping(path = "{groupId}")
    public void deleteGroup(@PathVariable("groupId") Long groupId){
        groupService.deleteGroup(groupId);
    }

    @GetMapping(path = "/{groupId}/employee")
    public List<Employee> getEmployeesInGroup(@PathVariable("groupId") Long groupId) {
        return groupService.getEmployeesInGroup(groupId);
    }

    @GetMapping(path = "/{groupId}/fill")
    public double getGroupFillPercentage(@PathVariable("groupId") Long groupId) {
        return groupService.getGroupFillPercentage(groupId);
    }
}
