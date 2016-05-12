package com.cyb.tms.entity;
// Generated May 12, 2016 11:55:51 AM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cyb.tms.entity.base.BaseEntity;

/**
 * TmsSprintMst generated by hbm2java
 */
@Entity
@Table(name = "tms_sprint_mst", catalog = "TaskManagement")
public class TmsSprintMst extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5340536044528825294L;
	private Long sprintId;
	private Date sprintEndDate;
	private int sprintHours;
	private String sprintName;
	private Date sprintStartDate;
	private String sprintStatus;
	private int sprintVelocity;
	private Set<TmsLeaveMst> tmsLeaveMsts = new HashSet<TmsLeaveMst>(0);
	private Set<TmsSprintUser> tmsSprintUsers = new HashSet<TmsSprintUser>(0);
	private Set<TmsEfforts> tmsEffortses = new HashSet<TmsEfforts>(0);

	public TmsSprintMst() {
	}

	public TmsSprintMst(Date sprintEndDate, int sprintHours, String sprintName, Date sprintStartDate,
			String sprintStatus, int sprintVelocity) {
		this.sprintEndDate = sprintEndDate;
		this.sprintHours = sprintHours;
		this.sprintName = sprintName;
		this.sprintStartDate = sprintStartDate;
		this.sprintStatus = sprintStatus;
		this.sprintVelocity = sprintVelocity;
	}

	public TmsSprintMst(Date sprintEndDate, int sprintHours, String sprintName, Date sprintStartDate,
			String sprintStatus, int sprintVelocity, Set<TmsLeaveMst> tmsLeaveMsts, Set<TmsSprintUser> tmsSprintUsers,
			Set<TmsEfforts> tmsEffortses) {
		this.sprintEndDate = sprintEndDate;
		this.sprintHours = sprintHours;
		this.sprintName = sprintName;
		this.sprintStartDate = sprintStartDate;
		this.sprintStatus = sprintStatus;
		this.sprintVelocity = sprintVelocity;
		this.tmsLeaveMsts = tmsLeaveMsts;
		this.tmsSprintUsers = tmsSprintUsers;
		this.tmsEffortses = tmsEffortses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "SPRINT_ID", unique = true, nullable = false)
	public Long getSprintId() {
		return this.sprintId;
	}

	public void setSprintId(Long sprintId) {
		this.sprintId = sprintId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SPRINT_END_DATE", nullable = false, length = 10)
	public Date getSprintEndDate() {
		return this.sprintEndDate;
	}

	public void setSprintEndDate(Date sprintEndDate) {
		this.sprintEndDate = sprintEndDate;
	}

	@Column(name = "SPRINT_HOURS", nullable = false)
	public int getSprintHours() {
		return this.sprintHours;
	}

	public void setSprintHours(int sprintHours) {
		this.sprintHours = sprintHours;
	}

	@Column(name = "SPRINT_NAME", nullable = false, length = 45)
	public String getSprintName() {
		return this.sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SPRINT_START_DATE", nullable = false, length = 10)
	public Date getSprintStartDate() {
		return this.sprintStartDate;
	}

	public void setSprintStartDate(Date sprintStartDate) {
		this.sprintStartDate = sprintStartDate;
	}

	@Column(name = "SPRINT_STATUS", nullable = false, length = 6)
	public String getSprintStatus() {
		return this.sprintStatus;
	}

	public void setSprintStatus(String sprintStatus) {
		this.sprintStatus = sprintStatus;
	}

	@Column(name = "SPRINT_VELOCITY", nullable = false)
	public int getSprintVelocity() {
		return this.sprintVelocity;
	}

	public void setSprintVelocity(int sprintVelocity) {
		this.sprintVelocity = sprintVelocity;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tmsSprintMst")
	public Set<TmsLeaveMst> getTmsLeaveMsts() {
		return this.tmsLeaveMsts;
	}

	public void setTmsLeaveMsts(Set<TmsLeaveMst> tmsLeaveMsts) {
		this.tmsLeaveMsts = tmsLeaveMsts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tmsSprintMst")
	public Set<TmsSprintUser> getTmsSprintUsers() {
		return this.tmsSprintUsers;
	}

	public void setTmsSprintUsers(Set<TmsSprintUser> tmsSprintUsers) {
		this.tmsSprintUsers = tmsSprintUsers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tmsSprintMst")
	public Set<TmsEfforts> getTmsEffortses() {
		return this.tmsEffortses;
	}

	public void setTmsEffortses(Set<TmsEfforts> tmsEffortses) {
		this.tmsEffortses = tmsEffortses;
	}

}