package com.ue.model.system;

// default package

/**
 * SysRole entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SysRole implements java.io.Serializable {

	// Fields

	private Integer sysRoleId;
	private String sysRoleName;
	private String sysRoleJur;
	private String sysRoleContent;

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** minimal constructor */
	public SysRole(Integer sysRoleId) {
		this.sysRoleId = sysRoleId;
	}

	/** full constructor */
	public SysRole(Integer sysRoleId, String sysRoleName, String sysRoleJur,
			String sysRoleContent) {
		this.sysRoleId = sysRoleId;
		this.sysRoleName = sysRoleName;
		this.sysRoleJur = sysRoleJur;
		this.sysRoleContent = sysRoleContent;
	}

	// Property accessors

	public Integer getSysRoleId() {
		return this.sysRoleId;
	}

	public void setSysRoleId(Integer sysRoleId) {
		this.sysRoleId = sysRoleId;
	}

	public String getSysRoleName() {
		return this.sysRoleName;
	}

	public void setSysRoleName(String sysRoleName) {
		this.sysRoleName = sysRoleName;
	}

	public String getSysRoleJur() {
		return this.sysRoleJur;
	}

	public void setSysRoleJur(String sysRoleJur) {
		this.sysRoleJur = sysRoleJur;
	}

	public String getSysRoleContent() {
		return this.sysRoleContent;
	}

	public void setSysRoleContent(String sysRoleContent) {
		this.sysRoleContent = sysRoleContent;
	}

}