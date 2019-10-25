package co.grandcircus;

public class Task {
	private String name;
	private String description;
	private String dueDate;
	private boolean completed;
	
/*
 * constructors for the Task class
 */
public Task() {
	name = "";
	description = "";
	dueDate = "";
	completed = false;
}
public Task(boolean completed, String date, String name, String description) {
	this.completed = completed;
	dueDate = date;
	this.name = name;
	this.description = description;
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
public String getDueDate() {
	return dueDate;
}
public void setDueDate(String dueDate) {
	this.dueDate = dueDate;
}
public boolean isCompleted() {
	return completed;
}
public void setCompleted(boolean completed) {
	this.completed = completed;
}
@Override 
public String toString() {
	return String.format("%-15s %-15s %-15s %-15s \n", completed, dueDate, name, description); //"%s\t %s\t %s\t %s\t \n"
	 
}



}
