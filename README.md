# Study Planner GUI Application

## Overview
The **Study Planner** is a simple desktop application built using **Java Swing (javax.swing)**.  
It allows students to organize and manage their study tasks in a graphical interface. Users can add tasks for different subjects, edit them, remove them, or clear the entire list.

This application demonstrates the use of **Java Swing components, event handling, and layout managers** to create a functional GUI program.

---

## Features

### Add Study Task
Users can enter:
- A **subject**
- A **task description**

Pressing **Add Task** adds the entry to the study list in the format:

`Subject - Task`

Example:

Math - Study Chapter 5

---

### View Tasks
All added tasks appear in a **scrollable list** in the center of the application.

---

### Edit Task
Users can:
1. Select a task from the list
2. Click **Edit Task**
3. Modify the task in the popup dialog

The updated task replaces the original entry in the list.

---

### Remove Task
Users can remove a task by:
1. Selecting the task
2. Clicking **Remove Task**

---

### Clear Tasks
Clicking **Clear Tasks** removes all tasks from the list.

---

### Exit Application
Clicking **Exit** closes the program.

---

## Technologies Used

- Java
- Java Swing (javax.swing)
- AWT Layout Managers

---

## GUI Components Used

| Component | Purpose |
|--------|--------|
| JFrame | Main application window |
| JPanel | Organizes sections of the interface |
| JLabel | Displays text labels |
| JTextField | Input for subject and task |
| JButton | Handles user actions |
| JList | Displays the list of study tasks |
| JScrollPane | Allows scrolling through tasks |


