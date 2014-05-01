package com.ue.model.system;

// default package

/**
 * SysUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private Integer sysUserId;
	private Integer sysRoleId;
	private String sysUserName;
	private String sysUserPwd;
	private String loginDate;
	private String loginIp;
	private Integer sysUserState;

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** full constructor */
	public SysUser(Integer sysRoleId, String sysUserName, String sysUserPwd,
			String loginDate, String loginIp, Integer sysUserState) {
		this.sysRoleId = sysRoleId;
		this.sysUserName = sysUserName;
		this.sysUserPwd = sysUserPwd;
		this.loginDate = loginDate;
		this.loginIp = loginIp;
		this.sysUserState = sysUserState;
	}

	// Property accessors

	public Integer getSysUserId() {
		return this.sysUserId;
	}

	public void setSysUserId(Integer sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String getSysUserName() {
		return this.sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public String getSysUserPwd() {
		return this.sysUserPwd;
	}

	public void setSysUserPwd(String sysUserPwd) {
		this.sysUserPwd = sysUserPwd;
	}

	public String getLoginDate() {
		return this.loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Integer getSysUserState() {
		return this.sysUserState;
	}

	public void setSysUserState(Integer sysUserState) {
		this.sysUserState = sysUserState;
	}

	public Integer getSysRoleId() {
		return sysRoleId;
	}

	public void setSysRoleId(Integer sysRoleId) {
		this.sysRoleId = sysRoleId;
	}

}