package ca.toronto.commoncomponents.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "SCHEDULE_RUN")
@EntityListeners(AuditingEntityListener.class)
public class ScheduleRun implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1529878221155530117L;

	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime createdAt;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SCHEDULER_RUN_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCHEDULER_ID")
	private Schedule scheduler;

	@Column(name = "STATUS")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "UPDATED_AT", nullable = false)
	@LastModifiedDate
	private LocalDateTime updatedAt;

	public ScheduleRun() {
		super();
	}

	public Schedule getScheduler() {
		return scheduler;
	}

	public void setScheduler(Schedule schedule) {
		this.scheduler = schedule;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
