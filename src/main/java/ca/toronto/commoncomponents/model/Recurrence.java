package ca.toronto.commoncomponents.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@Entity
@Table(name = "RECURRENCE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=Visibility.ANY, getterVisibility=Visibility.NONE, isGetterVisibility=Visibility.NONE, setterVisibility=Visibility.NONE)
public class Recurrence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3224365771615745096L;

	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	//@CreatedDate
	private LocalDateTime createdAt  = LocalDateTime.now();

	@Column(name = "CRON_EXPRESSION")
	private String cronExpression;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RECURRENCE_ID")
	private Long id;

	@Column(name = "END_TIME")
	private String endTime;

	@Column(name = "EXIT_CRITERIA")
	@Enumerated(EnumType.STRING)
	@NotNull
	private ExitCriteria exitCriteria;

	@Column(name = "FREQUENCY")
	@Enumerated(EnumType.STRING)
	@NotNull
	private Frequency frequency;

	@Column(name = "TIME_INTERVAL")
	private int interval;

	@ElementCollection
	@CollectionTable(name = "RECURRENCE_MONTH_DAYS")
	private List<String> monthDays;

	//@ElementCollection
	//@CollectionTable(name = "RECURRENCE_RUN_TIMES")
	//@JsonDeserialize(using = RuntimeDeserializer.class)
	@OneToMany(mappedBy="recurrence", cascade=CascadeType.ALL)
	private List<RunTime> runTimes;
	
	 @OneToOne(fetch=FetchType.LAZY, mappedBy="recurrence")
	 private Schedule schedule;

	@JsonSerialize(using = ToStringSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@Column(name = "START_TIME")
	private LocalDateTime startTime;

	@Column(name = "UPDATED_AT", nullable = false)
	//@LastModifiedDate
	private LocalDateTime updatedAt = LocalDateTime.now();

	@ElementCollection
	@CollectionTable(name = "RECURRENCE_WEEK_DAYS")
	private List<String> weekDays;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public ExitCriteria getExitCriteria() {
		return exitCriteria;
	}

	public void setExitCriteria(ExitCriteria exitCriteria) {
		this.exitCriteria = exitCriteria;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public List<String> getMonthDays() {
		return monthDays;
	}

	public void setMonthDays(List<String> monthDays) {
		this.monthDays = monthDays;
	}

	public List<RunTime> getRunTimes() {
		return runTimes;
	}

	public void setRunTimes(List<RunTime> runTime) {
		this.runTimes = runTime;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public List<String> getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(List<String> weekDays) {
		this.weekDays = weekDays;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", id).append("startTime", startTime)
				.append("endTime", endTime).append("exitCriteria", exitCriteria).append("frequency", frequency)
				.append("interval", interval).append("monthDays", monthDays).append("runTimes", runTimes)
				.append("weekDays", weekDays).toString();
	}

}
