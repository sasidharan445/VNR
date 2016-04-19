package com.vnr.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_ACCOUNT")
public class UserAccount implements Serializable {
		
	private static final long serialVersionUID = -5329772924753696258L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ACCOUNT_ID")
	private long userAccountId;
	
	@Column(name="LOGIN_NAME")
	private String loginName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@OneToMany(mappedBy="userAccount",cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
    private Set<UserRole> userRoles;
	
	public long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(long userAccountId) {
		this.userAccountId = userAccountId;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	

}
