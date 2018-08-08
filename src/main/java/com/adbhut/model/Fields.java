package com.adbhut.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"external_id"
})

@Getter
@Setter
public class Fields {

@JsonProperty("external_id")
private String externalId;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
