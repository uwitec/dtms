package com.ue.model.system;

// default package

/**
 * SiteConfig entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SiteConfig implements java.io.Serializable {

	// Fields

	private Integer configId;
	private String siteName; // 网站名称

	private String siteUrl; // 网站主域名
	private String siteLogo; // 网站logon
	private String siteIcp; // 网站ICP备案
	private String siteClose;
	private String siteCloseNote;// 客服电话，多个用逗号隔开
	private String siteMeta1;// 网站关键词
	private String siteMeta2;// 网站详细说明
	private Integer indNewZp;
	private Integer indNewJl;// 商品订购日期范围是10天
	private String siteQq; // 网站客服QQ
	private String newPerSh;// 网站景点方面押金
	private String newComSh;// 网站住宿方面押金
	private String perRegClose;// 网站餐饮方面押金
	private String perRegCloseNote;// 网站活动方面押金

	private String comRegClose;
	private String comRegCloseNote;
	private String regNoName;
	private String newPerSendFlag;
	private String newPerSend;
	private String newComSendFlag;
	private String newComSend;
	private String mailSmtp; // 网站EMAIL 提供商
	private String mailUserName; // 网站EMAIL账号
	private String mailPassWord;// 网站EMAIL密码
	private String jianjie1;// 支付宝账号
	private String jianjie2;// 支付宝ID
	private String jianjie3;// 支付宝密匙
	private String jianjie4;
	private String jianjie5;
	private String jianjie6;
	private String jianjie7;
	private String companyName;// 公司名称
	private String addr;// 公司地址
	private String tel;// 联系电话
	private String fax;// 传真
	private String email;// 官方EMAIL

	// Constructors

	/** default constructor */
	public SiteConfig() {
	}

	/** full constructor */
	public SiteConfig(String siteName, String siteUrl, String siteLogo,
			String siteIcp, String siteClose, String siteCloseNote,
			String siteMeta1, String siteMeta2, Integer indNewZp,
			Integer indNewJl, String siteQq, String newPerSh, String newComSh,
			String perRegClose, String perRegCloseNote, String comRegClose,
			String comRegCloseNote, String regNoName, String newPerSendFlag,
			String newPerSend, String newComSendFlag, String newComSend,
			String mailSmtp, String mailUserName, String mailPassWord,
			String jianjie1, String jianjie2, String jianjie3, String jianjie4,
			String jianjie5, String jianjie6, String jianjie7,
			String companyName, String addr, String tel, String fax,
			String email) {
		this.siteName = siteName;
		this.siteUrl = siteUrl;
		this.siteLogo = siteLogo;
		this.siteIcp = siteIcp;
		this.siteClose = siteClose;
		this.siteCloseNote = siteCloseNote;
		this.siteMeta1 = siteMeta1;
		this.siteMeta2 = siteMeta2;
		this.indNewZp = indNewZp;
		this.indNewJl = indNewJl;
		this.siteQq = siteQq;
		this.newPerSh = newPerSh;
		this.newComSh = newComSh;
		this.perRegClose = perRegClose;
		this.perRegCloseNote = perRegCloseNote;
		this.comRegClose = comRegClose;
		this.comRegCloseNote = comRegCloseNote;
		this.regNoName = regNoName;
		this.newPerSendFlag = newPerSendFlag;
		this.newPerSend = newPerSend;
		this.newComSendFlag = newComSendFlag;
		this.newComSend = newComSend;
		this.mailSmtp = mailSmtp;
		this.mailUserName = mailUserName;
		this.mailPassWord = mailPassWord;
		this.jianjie1 = jianjie1;
		this.jianjie2 = jianjie2;
		this.jianjie3 = jianjie3;
		this.jianjie4 = jianjie4;
		this.jianjie5 = jianjie5;
		this.jianjie6 = jianjie6;
		this.jianjie7 = jianjie7;
		this.companyName = companyName;
		this.addr = addr;
		this.tel = tel;
		this.fax = fax;
		this.email = email;
	}

	// Property accessors

	public Integer getConfigId() {
		return this.configId;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public String getSiteName() {
		return this.siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteUrl() {
		return this.siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getSiteLogo() {
		return this.siteLogo;
	}

	public void setSiteLogo(String siteLogo) {
		this.siteLogo = siteLogo;
	}

	public String getSiteIcp() {
		return this.siteIcp;
	}

	public void setSiteIcp(String siteIcp) {
		this.siteIcp = siteIcp;
	}

	public String getSiteClose() {
		return this.siteClose;
	}

	public void setSiteClose(String siteClose) {
		this.siteClose = siteClose;
	}

	public String getSiteCloseNote() {
		return this.siteCloseNote;
	}

	public void setSiteCloseNote(String siteCloseNote) {
		this.siteCloseNote = siteCloseNote;
	}

	public String getSiteMeta1() {
		return this.siteMeta1;
	}

	public void setSiteMeta1(String siteMeta1) {
		this.siteMeta1 = siteMeta1;
	}

	public String getSiteMeta2() {
		return this.siteMeta2;
	}

	public void setSiteMeta2(String siteMeta2) {
		this.siteMeta2 = siteMeta2;
	}

	public Integer getIndNewZp() {
		return this.indNewZp;
	}

	public void setIndNewZp(Integer indNewZp) {
		this.indNewZp = indNewZp;
	}

	public Integer getIndNewJl() {
		return this.indNewJl;
	}

	public void setIndNewJl(Integer indNewJl) {
		this.indNewJl = indNewJl;
	}

	public String getSiteQq() {
		return this.siteQq;
	}

	public void setSiteQq(String siteQq) {
		this.siteQq = siteQq;
	}

	public String getNewPerSh() {
		return this.newPerSh;
	}

	public void setNewPerSh(String newPerSh) {
		this.newPerSh = newPerSh;
	}

	public String getNewComSh() {
		return this.newComSh;
	}

	public void setNewComSh(String newComSh) {
		this.newComSh = newComSh;
	}

	public String getPerRegClose() {
		return this.perRegClose;
	}

	public void setPerRegClose(String perRegClose) {
		this.perRegClose = perRegClose;
	}

	public String getPerRegCloseNote() {
		return this.perRegCloseNote;
	}

	public void setPerRegCloseNote(String perRegCloseNote) {
		this.perRegCloseNote = perRegCloseNote;
	}

	public String getComRegClose() {
		return this.comRegClose;
	}

	public void setComRegClose(String comRegClose) {
		this.comRegClose = comRegClose;
	}

	public String getComRegCloseNote() {
		return this.comRegCloseNote;
	}

	public void setComRegCloseNote(String comRegCloseNote) {
		this.comRegCloseNote = comRegCloseNote;
	}

	public String getRegNoName() {
		return this.regNoName;
	}

	public void setRegNoName(String regNoName) {
		this.regNoName = regNoName;
	}

	public String getNewPerSendFlag() {
		return this.newPerSendFlag;
	}

	public void setNewPerSendFlag(String newPerSendFlag) {
		this.newPerSendFlag = newPerSendFlag;
	}

	public String getNewPerSend() {
		return this.newPerSend;
	}

	public void setNewPerSend(String newPerSend) {
		this.newPerSend = newPerSend;
	}

	public String getNewComSendFlag() {
		return this.newComSendFlag;
	}

	public void setNewComSendFlag(String newComSendFlag) {
		this.newComSendFlag = newComSendFlag;
	}

	public String getNewComSend() {
		return this.newComSend;
	}

	public void setNewComSend(String newComSend) {
		this.newComSend = newComSend;
	}

	public String getMailSmtp() {
		return this.mailSmtp;
	}

	public void setMailSmtp(String mailSmtp) {
		this.mailSmtp = mailSmtp;
	}

	public String getMailUserName() {
		return this.mailUserName;
	}

	public void setMailUserName(String mailUserName) {
		this.mailUserName = mailUserName;
	}

	public String getMailPassWord() {
		return this.mailPassWord;
	}

	public void setMailPassWord(String mailPassWord) {
		this.mailPassWord = mailPassWord;
	}

	public String getJianjie1() {
		return this.jianjie1;
	}

	public void setJianjie1(String jianjie1) {
		this.jianjie1 = jianjie1;
	}

	public String getJianjie2() {
		return this.jianjie2;
	}

	public void setJianjie2(String jianjie2) {
		this.jianjie2 = jianjie2;
	}

	public String getJianjie3() {
		return this.jianjie3;
	}

	public void setJianjie3(String jianjie3) {
		this.jianjie3 = jianjie3;
	}

	public String getJianjie4() {
		return this.jianjie4;
	}

	public void setJianjie4(String jianjie4) {
		this.jianjie4 = jianjie4;
	}

	public String getJianjie5() {
		return this.jianjie5;
	}

	public void setJianjie5(String jianjie5) {
		this.jianjie5 = jianjie5;
	}

	public String getJianjie6() {
		return this.jianjie6;
	}

	public void setJianjie6(String jianjie6) {
		this.jianjie6 = jianjie6;
	}

	public String getJianjie7() {
		return this.jianjie7;
	}

	public void setJianjie7(String jianjie7) {
		this.jianjie7 = jianjie7;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}