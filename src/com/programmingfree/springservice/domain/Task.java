package com.programmingfree.springservice.domain;

public class Task {
	 private int IdEvent;
	  private String EventName;
	  private String Description; 
	  private String Country;
	  public int getIdEvent() {
	   return IdEvent;
	  }
	  public void setIdEvent(int IdEvent) {
	   this.IdEvent = IdEvent;
	  }
	  public String getEventName() {
	   return EventName;
	  }
	  public void setEventName(String EventName) {
	   this.EventName = EventName;
	  }
	  public String getDescription() {
	   return Description;
	  }
	  public void setDescription(String Description) {
	   this.Description = Description;
	  }
	  public String getCountry() {
	   return Country;
	  }
	  public void setCountry(String Country) {
	   this.Country = Country;
	  }
	  
	  @Override
	  public String toString() {
	   return "Task [task_id=" + IdEvent + ", task_name=" + EventName
	     + ", task_description=" + Description + ", task_priority="
	     + Country +"]";
	  }
	}
