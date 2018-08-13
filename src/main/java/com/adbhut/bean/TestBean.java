package com.adbhut.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TestBean {
	@JsonProperty("value")
	private int value;
	@JsonProperty("first_name")
	private String name;
	@JsonProperty("flag")
	private boolean flag;
}
