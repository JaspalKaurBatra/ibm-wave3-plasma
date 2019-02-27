package com.stackroute.plasma.repository;

import com.stackroute.plasma.model.Relationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface RelationshipRespository extends Neo4jRepository<Relationship,Long> {

    /* Creates the relationship from description node to concept node */
    @Query("MATCH (c:Domain),(d:Description) " +
            "WHERE d.concept={concept} AND c.name = d.concept AND c.type = \"concept\" " +
            "CREATE x=(d)-[r:Details_of { confidenceScore:{confidenceScore},level:{level} }]->(c) RETURN r")
    Relationship create(@Param("concept")String concept,@Param("confidenceScore")long confidenceScore,@Param("level")String level);

    /* Reads the Concept node from  Domain Ontology */
    //@Query("MATCH (c:DomainOntology) WHERE c.name={name} AND c.class=\"concept\" RETURN c")
    //String getOneConcept(@Param("name") String name);
    //now the problem is I am not specifying the domain for searching the node which is important


    /* Deletes the relationship from description node to concept node */
    @Query("MATCH (d)-[r:Details_of]->(c) WHERE d.concept={concept} DETACH DELETE r RETURN r")
    Relationship delete(@Param("concept") String concept);

}







