package com.example.restapi.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<GroupEmployee, Long> {

    @Query("SELECT g FROM GroupEmployee g WHERE g.name =?1")
    Optional<GroupEmployee> findGroup(String name);
}
