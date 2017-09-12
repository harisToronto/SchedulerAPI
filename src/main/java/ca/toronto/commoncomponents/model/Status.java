package ca.toronto.commoncomponents.model;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {
	@JsonProperty("active")
	ACTIVE, @JsonProperty("inactive")
	INACTIVE, @JsonProperty("completed_success")
	COMPLETED_SUCCESS, @JsonProperty("pending")
	PENDING, @JsonProperty("completed_failure")
	COMPLETED_FAILURE;

	@Override
	public String toString() {
		return StringUtils.trimToEmpty(this.name()).toLowerCase();
	}
}
