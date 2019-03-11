package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Relationship;
import com.stackroute.plasma.repository.RelationshipRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipImpl implements RelationshipService {

    @Autowired
    RelationshipRespository relationshipRespository;

   /* @Override
    public List<Relationship> get() {
        return null;
    }*/

    @Override
    public void create(String concept, float confidenceScore, String level,String url, String timestamp) {
        relationshipRespository.create(concept,confidenceScore,level,url,timestamp);
    }

    @Override
    public Relationship delete(String concept) {
        return relationshipRespository.delete("Erlang");
    }
}
