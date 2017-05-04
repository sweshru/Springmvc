package com.programmingfree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.programmingfree.springservice.domain.Task;
import com.programmingfree.springservice.utility.DBUtility;

public class TaskManagerService {
	 private Connection connection;
	 public TaskManagerService() {
	  connection = DBUtility.getConnection();
	 }
	 public void addTask(Task task) {
	  try {
	   PreparedStatement preparedStatement = connection
	     .prepareStatement("insert into EVENTDETAIL (EVENT_TITLE,EVENT_DESC,ID_EVENT,COUNTRY) values(?,?,?,?)");
	   System.out.println("Task:"+task.getEventName());
	   preparedStatement.setString(1, task.getEventName());
	   preparedStatement.setString(2, task.getDescription());
	   preparedStatement.setLong(3, task.getIdEvent());
	   preparedStatement.setString(4, task.getCountry());
	   preparedStatement.executeUpdate();
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	 }
	 public void archiveTask(int taskId) {
	  try {
	   PreparedStatement preparedStatement = connection
	     .prepareStatement("update task_list set task_archived=true where task_id=?");
	   // Parameters start with 1
	   preparedStatement.setInt(1, taskId);
	   preparedStatement.executeUpdate();
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	 }
	 public void updateTask(Task task) throws ParseException {
	  try {
	   PreparedStatement preparedStatement = connection
	     .prepareStatement("update EVENTDETAIL set EVENT_TITLE=? ,EVENT_DESC=?,ID_EVENT=?,COUNTRY=? where ID_EVENT=?");
	   preparedStatement.setString(1, task.getEventName());
	   preparedStatement.setString(2, task.getDescription());
	   preparedStatement.setLong(3, task.getIdEvent());
	   preparedStatement.setString(4, task.getCountry());
	   preparedStatement.setInt(5, task.getIdEvent());
	   preparedStatement.executeUpdate();
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	 }
	 public void changeTaskStatus(int taskId,String status) throws ParseException {
	   try {
	    PreparedStatement preparedStatement = connection
	      .prepareStatement("update task_list set task_status=? where task_id=?");
	    preparedStatement.setString(1,status);
	    preparedStatement.setInt(2, taskId);
	    preparedStatement.executeUpdate();
	   } catch (SQLException e) {
	    e.printStackTrace();
	   }
	  }
	 public List<Task> getAllTasks() {
		 System.out.println("Task:");
	  List<Task> tasks = new ArrayList<Task>();
	  try {
	   Statement statement = connection.createStatement();
	   ResultSet rs = statement.executeQuery("select * from EVENTDETAIL");
	   while (rs.next()) {
	    Task task = new Task();
	    System.out.println(rs.getString(1));
	    task.setIdEvent(rs.getInt(3));
	    task.setEventName(rs.getString(1));
	    task.setDescription(rs.getString(2));    
	    task.setCountry(rs.getString(4));
	    tasks.add(task);
	   }
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	  return tasks;
	 }
	 public Task getTaskById(int taskId) {
	  Task task = new Task();
	  try {
	   PreparedStatement preparedStatement = connection.
	     prepareStatement("select * from EVENTDETAIL");
	   preparedStatement.setInt(1, taskId);
	   ResultSet rs = preparedStatement.executeQuery();
	   if (rs.next()) {
		   task.setIdEvent(rs.getInt(3));
		    task.setEventName(rs.getString(1));
		    task.setDescription(rs.getString(2));    
		    task.setCountry(rs.getString(4));;
	   }
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	  return task;
	 }
	}
