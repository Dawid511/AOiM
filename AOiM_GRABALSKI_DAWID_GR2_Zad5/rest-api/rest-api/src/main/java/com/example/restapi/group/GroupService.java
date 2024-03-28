package com.example.restapi.group;

import com.example.restapi.emp.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<GroupEmployee> getGroups(){
        return groupRepository.findAll();
    }

    public void addGroup(GroupEmployee group){
        Optional<GroupEmployee> grp = groupRepository.findGroup(group.getName());
        if(grp.isPresent()){
            throw new IllegalStateException("Taka grupa juz istnieje");
        }
            groupRepository.save(group);


    }

    public void deleteGroup(Long groupId) {
        boolean exists = groupRepository.existsById(groupId);

        if(!exists) {
            throw new IllegalStateException("nie ma takiej grupy!");
        }else
            groupRepository.deleteById(groupId);
    }

    public List<Employee> getEmployeesInGroup(Long groupId) {
        return groupRepository.findById(groupId)
                .map(GroupEmployee::getListOfEmployees)
                .orElseThrow(() -> new IllegalStateException("Grupa o podanym ID nie istnieje"));
    }

    public double getGroupFillPercentage(Long groupId) {
        GroupEmployee group = groupRepository.findById(groupId)
                .orElseThrow(() -> new IllegalStateException("Grupa o podanym ID nie istnieje"));
        int maxEmployees = 10;
        int currentEmployees = group.getListOfEmployees().size();

        return maxEmployees > 0 ? (double) currentEmployees / maxEmployees * 100 : 0;
        //return currentEmployees;
    }
}
