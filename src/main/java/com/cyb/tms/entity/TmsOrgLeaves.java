package com.cyb.tms.entity;
// Generated May 17, 2016 12:38:28 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.cyb.tms.entity.base.BaseEntity;

/**
 * TmsOrgLeaves generated by hbm2java
 */
@Entity
@Table(name = "tms_org_leaves", catalog = "TaskManagement", uniqueConstraints = @UniqueConstraint(columnNames = "DATE"))
public class TmsOrgLeaves extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3989265561790750415L;
	private Long id;
	private Date date;
	private String description;

	public TmsOrgLeaves() {
	}

	public TmsOrgLeaves(Date date, String description) {
		this.date = date;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE", unique = true, length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "DESCRIPTION", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
