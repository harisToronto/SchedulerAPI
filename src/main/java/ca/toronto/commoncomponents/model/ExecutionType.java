package ca.toronto.commoncomponents.model;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ExecutionType {
	@JsonProperty("single")
	SINGLE, 
	@JsonProperty("recurring")
	RECURRING;
		
	@Override
	public String toString() {
        return StringUtils.trimToEmpty(this.name()).toLowerCase();
    }
}