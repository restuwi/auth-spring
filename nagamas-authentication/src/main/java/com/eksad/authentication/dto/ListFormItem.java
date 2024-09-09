package com.eksad.authentication.dto;

public class ListFormItem{
	private String formId;
	private String emplId;
	private String menuId;
	private String description;
	private String userId;

	private Boolean readAccess;

	private Boolean writeAccess;

	private Boolean deleteAccess;

	private Boolean editAccess;


	public void setFormId(String formId){
		this.formId = formId;
	}

	public String getFormId(){
		return formId;
	}

	public void setEmplId(String emplId){
		this.emplId = emplId;
	}

	public String getEmplId(){
		return emplId;
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

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public Boolean getReadAccess() {
		return readAccess;
	}

	public void setReadAccess(Boolean readAccess) {
		this.readAccess = readAccess;
	}

	public Boolean getWriteAccess() {
		return writeAccess;
	}

	public void setWriteAccess(Boolean writeAccess) {
		this.writeAccess = writeAccess;
	}

	public Boolean getDeleteAccess() {
		return deleteAccess;
	}

	public void setDeleteAccess(Boolean deleteAccess) {
		this.deleteAccess = deleteAccess;
	}

	public Boolean getEditAccess() {
		return editAccess;
	}

	public void setEditAccess(Boolean editAccess) {
		this.editAccess = editAccess;
	}
}
