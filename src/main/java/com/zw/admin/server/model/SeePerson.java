package com.zw.admin.server.model;



public class SeePerson extends BaseEntity<Long> {

	private String dealDep;
	private String dealEmail;
	private Integer dealId;
	private String dealName;
	private String dealNote;
	private String dealNumber;
	private String dealedDep;
	private String dealedEmail;
	private String dealedName;
	private String dealedNumber;
	private String rectifictId;

	public String getDealDep() {
		return dealDep;
	}
	public void setDealDep(String dealDep) {
		this.dealDep = dealDep;
	}
	public String getDealEmail() {
		return dealEmail;
	}
	public void setDealEmail(String dealEmail) {
		this.dealEmail = dealEmail;
	}
	public Integer getDealId() {
		return dealId;
	}
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
	public String getDealName() {
		return dealName;
	}
	public void setDealName(String dealName) {
		this.dealName = dealName;
	}
	public String getDealNote() {
		return dealNote;
	}
	public void setDealNote(String dealNote) {
		this.dealNote = dealNote;
	}
	public String getDealNumber() {
		return dealNumber;
	}
	public void setDealNumber(String dealNumber) {
		this.dealNumber = dealNumber;
	}
	public String getDealedDep() {
		return dealedDep;
	}
	public void setDealedDep(String dealedDep) {
		this.dealedDep = dealedDep;
	}
	public String getDealedEmail() {
		return dealedEmail;
	}
	public void setDealedEmail(String dealedEmail) {
		this.dealedEmail = dealedEmail;
	}
	public String getDealedName() {
		return dealedName;
	}
	public void setDealedName(String dealedName) {
		this.dealedName = dealedName;
	}
	public String getDealedNumber() {
		return dealedNumber;
	}
	public void setDealedNumber(String dealedNumber) {
		this.dealedNumber = dealedNumber;
	}
	public String getRectifictId() {
		return rectifictId;
	}
	public void setRectifictId(String rectifictId) {
		this.rectifictId = rectifictId;
	}

}
