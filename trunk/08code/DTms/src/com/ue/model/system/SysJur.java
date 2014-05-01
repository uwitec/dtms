package com.ue.model.system;

// default package

/**
 * SysJur entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SysJur implements java.io.Serializable {

	// Fields

	private Integer sysJurId;
	private String sysJurCode;
	private String sysJurName;

	// Constructors

	/** default constructor */
	public SysJur() {
	}

	/** minimal constructor */
	public SysJur(Integer sysJurId) {
		this.sysJurId = sysJurId;
	}

	/** full constructor */
	public SysJur(Integer sysJurId, String sysJurCode, String sysJurName) {
		this.sysJurId = sysJurId;
		this.sysJurCode = sysJurCode;
		this.sysJurName = sysJurName;
	}

	// Property accessors

	public Integer getSysJurId() {
		return this.sysJurId;
	}

	public void setSysJurId(Integer sysJurId) {
		this.sysJurId = sysJurId;
	}

	public String getSysJurCode() {
		return this.sysJurCode;
	}

	public void setSysJurCode(String sysJurCode) {
		this.sysJurCode = sysJurCode;
	}

	public String getSysJurName() {
		return this.sysJurName;
	}

	public void setSysJurName(String sysJurName) {
		this.sysJurName = sysJurName;
	}

}