package com.adbhut.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "fields" })

@Getter
@Setter
@ToString
public class Example {

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
