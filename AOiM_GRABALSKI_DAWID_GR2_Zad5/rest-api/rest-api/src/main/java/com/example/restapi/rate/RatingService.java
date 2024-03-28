package com.example.restapi.rate;


import com.example.restapi.group.GroupEmployee;
import com.example.restapi.group.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    RatingRepository ratingRepository;
    GroupRepository groupRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository, GroupRepository groupRepository){
        this.ratingRepository = ratingRepository;
        this.groupRepository = groupRepository;
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public void addRating(Rating rate, String nazwa) {
        Optional<GroupEmployee> optionalGroup = groupRepository.findGroup(nazwa);
        rate.setGrupa(optionalGroup.get());
        ratingRepository.save(rate);
    }

}
