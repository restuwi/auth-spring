package com.eksad.authentication.dto;

import java.util.List;

public class MenuAccessResponseDto {
	private String empId;
	private String menuId;
	private String description;
	private List<ListFormItem> listForm;
	private String userId;

	public void setEmpId(String empId){
		this.empId = empId;
	}

	public String getEmpId(){
		return empId;
	}

	public void setMenuId(String menuId){
		this.menuId = menuId;
	}

	public String getMenuId(){
		return menuId;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setListForm(List<ListFormItem> listForm){
		this.listForm = listForm;
	}

	public List<ListFormItem> getListForm(){
		return listForm;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}
}