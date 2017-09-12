package ca.toronto.commoncomponents.utils;

import org.apache.commons.lang3.StringUtils;

import ca.toronto.commoncomponents.model.Payload;
import ca.toronto.commoncomponents.model.Schedule;
import ca.toronto.commoncomponents.utils.exception.MissingNecessaryPropertiesInJsonException;

public class JsonValidationUtils {

	public static final void validate(Payload payload) throws MissingNecessaryPropertiesInJsonException {
		Schedule schedule;
		if (payload == null || (schedule = payload.getSchedule()) == null
				|| StringUtils.isBlank(schedule.getEndPointUrl()) || schedule.getType() == null
				|| !schedule.isEnabled()) {
			throw new MissingNecessaryPropertiesInJsonException(
					"Not provided all of the required parameters to proceed...");
		}

	}

}
