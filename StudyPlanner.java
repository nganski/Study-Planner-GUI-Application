package studyplanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Ngan
 */
public class StudyPlanner extends JFrame {

    // Title
    private JLabel title = new JLabel("Study Planner");

    // Input
    private JTextField subjectField = new JTextField(15);
    private JTextField taskField = new JTextField(20);

    // Buttons
    private JButton addButton = new JButton("Add Task");
    private JButton editButton = new JButton("Edit Task");
    private JButton removeButton = new JButton("Remove Task");
    private JButton clearButton = new JButton("Clear Tasks");
    private JButton exitButton = new JButton("Exit");

    // Task list
    private DefaultListModel<String> taskModel = new DefaultListModel<>();
    private JList<String> taskList = new JList<>(taskModel);

    public StudyPlanner() {

        setTitle("Study Planner");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        // ---------- TITLE ----------
        title.setFont(new Font("Segoe UI", Font.BOLD, 32));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(title, BorderLayout.NORTH);

        // ---------- INPUT PANEL ----------
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3,2,10,10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Study Task"));

        inputPanel.add(new JLabel("Subject:"));
        inputPanel.add(subjectField);

        inputPanel.add(new JLabel("Task:"));
        inputPanel.add(taskField);

        inputPanel.add(new JLabel(""));
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.WEST);

        // ---------- TASK LIST ----------
        taskList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Study Tasks"));

        add(scrollPane, BorderLayout.CENTER);

        // ---------- BUTTON PANEL ----------
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER,15,10));

        controlPanel.add(editButton);
        controlPanel.add(removeButton);
        controlPanel.add(clearButton);
        controlPanel.add(exitButton);

        add(controlPanel, BorderLayout.SOUTH);

        // ---------- BUTTON EVENTS ----------

        addButton.addActionListener(e -> addTask());
        removeButton.addActionListener(e -> removeTask());
        clearButton.addActionListener(e -> taskModel.clear());
        exitButton.addActionListener(e -> System.exit(0));
        editButton.addActionListener(e -> editTask());

        setVisible(true);
    }

    // ---------- METHODS ----------

    private void addTask() {

        String subject = subjectField.getText().trim();
        String task = taskField.getText().trim();

        if(!subject.isEmpty() && !task.isEmpty()) {
            taskModel.addElement(subject + " - " + task);
            subjectField.setText("");
            taskField.setText("");
        }
    }

    private void removeTask() {

        int index = taskList.getSelectedIndex();

        if(index != -1) {
            taskModel.remove(index);
        }
    }

    private void editTask() {

        int index = taskList.getSelectedIndex();

        if(index != -1) {

            String current = taskModel.get(index);

            String updated = JOptionPane.showInputDialog(
                    this,
                    "Edit Task",
                    current
            );

            if(updated != null && !updated.trim().isEmpty()) {
                taskModel.set(index, updated);
            }
        }
    }

    public static void main(String[] args) {
        new StudyPlanner();
    }

}
