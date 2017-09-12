package ca.toronto.commoncomponents.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "SCHEDULE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=Visibility.ANY, getterVisibility=Visibility.NONE, isGetterVisibility=Visibility.NONE, setterVisibility=Visibility.NONE)
public class Schedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7656992554323421515L;

	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	//@CreatedDate
	private LocalDateTime createdAt = LocalDateTime.now();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SCHEDULER_ID")
	private Long id;

	@Column(name = "ENABLED")
	@NotNull
	private boolean enabled;

	@Column(name = "ENDPOINT_URL")
	@NotNull
	private String endPointUrl;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "RECURRENCE_ID")
	private Recurrence recurrence;

	@Column(name = "RUN_PARAMETERS")
	@Lob
	private String runParameters;
	
	@OneToMany(mappedBy="scheduler")
	private List<ScheduleRun> scheduleRuns;

	@Column(name = "EXECUTION_TYPE")
	@NotNull
	@Enumerated(EnumType.STRING)
	private ExecutionType type;

	@Column(name = "UPDATED_AT", nullable = false)
	//@LastModifiedDate
	private LocalDateTime updatedAt  = LocalDateTime.now();

	public Schedule() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEndPointUrl() {
		return endPointUrl;
	}

	public void setEndPointUrl(String endPointUrl) {
		this.endPointUrl = endPointUrl;
	}

	public Recurrence getRecurrence() {
		return recurrence;
	}

	public void setRecurrence(Recurrence recurrence) {
		this.recurrence = recurrence;
	}

	public ExecutionType getType() {
		return type;
	}

	public void setType(ExecutionType type) {
		this.type = type;
	}

	public String getRunParameters() {
		return runParameters;
	}

	public void setRunParameters(String runParameters) {
		this.runParameters = runParameters;
	}

	public List<ScheduleRun> getScheduleRuns() {
		return scheduleRuns;
	}

	public void setScheduleRuns(List<ScheduleRun> scheduleRuns) {
		this.scheduleRuns = scheduleRuns;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", id).append("id", id)
				.append("enabled", enabled).append("endPointUrl", endPointUrl).append("recurrence", recurrence)
				.append("type", type).toString();
	}
}
