package ca.toronto.commoncomponents.model;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Frequency {
	@JsonProperty("hours")
	HOURS, 
	@JsonProperty("days")
	DAYS,
	@JsonProperty("minutes")
	MINUTES,
	@JsonProperty("weeks")
	WEEKS,
	@JsonProperty("months")
	MONTHS;
	
	@Override
	public String toString() {
        return StringUtils.trimToEmpty(this.name()).toLowerCase();
    }
}