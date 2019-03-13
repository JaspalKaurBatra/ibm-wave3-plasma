package com.stackroute.knowledgequeryservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@Getter
@Setter
@NodeEntity
public class Document {
    @Id
    @GeneratedValue
    private long id;

    @ApiModelProperty(notes = "Timestamp as per the search-service")
    @Property
    private String timestamp;

    @ApiModelProperty(notes = "Concept to search for")
    @Property
    private String concept;

    @ApiModelProperty(notes = "Concept to search for under particular domain")
    @Property
    private String domain;

    @ApiModelProperty(notes = "Basic description for the URL")
    @Property
    private String description;

    @ApiModelProperty(notes = "Title of the URL")
    @Property
    private String title;

    @ApiModelProperty(notes = "URL contains the details of the concept, present under domain")
    @Property
    private String url;

    @ApiModelProperty(notes = "basic keywords present in the URL")
    @Property
    private String keywords;

}
