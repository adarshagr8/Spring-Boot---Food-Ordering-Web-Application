package com.madhuram.web.entities;

public class Categories {
	private Integer CategoryID;
	private String CategoryName;
	private String CategoryDescription;
	private String ManagerName;

	public String getCategoryDescription() {
		return CategoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}

	public Integer getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(Integer categoryID) {
		CategoryID = categoryID;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getManagerName() {
		return ManagerName;
	}

	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}

}