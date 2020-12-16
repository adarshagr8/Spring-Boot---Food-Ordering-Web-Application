package com.madhuram.web.entities;

public class Gallery {
	private Integer PhotoID;
	private String Tag;
	private String Image;
	private String DateAdded;
	
	public Integer getPhotoID() {
		return PhotoID;
	}
	public void setPhotoID(Integer photoID) {
		PhotoID = photoID;
	}
	public String getTag() {
		return Tag;
	}
	public void setTag(String tag) {
		Tag = tag;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getDateAdded() {
		return DateAdded;
	}
	public void setDateAdded(String dateAdded) {
		DateAdded = dateAdded;
	}
	
	
}
