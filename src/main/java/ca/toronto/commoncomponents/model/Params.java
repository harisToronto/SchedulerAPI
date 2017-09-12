package ca.toronto.commoncomponents.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Params {
	private String in;

	public String getIn() {
		return in;
	}

	public void setIn(String in) {
		this.in = in;
	}

}
