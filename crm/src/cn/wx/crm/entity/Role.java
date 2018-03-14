package cn.wx.crm.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Role extends IdEntity{

	// 角色名称
	private String name;
	// 角色描述
	private String description;
	// 角色状态: 角色是否可用
	private boolean enabled;
	// 角色拥有的权限
	private List<Authority> authorities = new ArrayList<>();
	//该角色分配给了哪些用户
	private Set<User> users = new HashSet<>();
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
