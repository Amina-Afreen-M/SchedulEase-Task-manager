package com.example.SchedulEase.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.*;

import com.example.SchedulEase.repo.IToDoRepo;
import com.example.SchedulEase.model.ToDo;
import com.example.SchedulEase.model.ToDo.Task;

@Service
public class ToDoService {

    @Autowired
    private IToDoRepo repo;

    // Priority mapping
    private static final Map<BigInteger, Integer> priorityMap = new HashMap<>();

    static {
        // Example priorities (1 = High, 2 = Medium, 3 = Low)
        priorityMap.put(new BigInteger("1"), 1); // Assuming ID is 1
        priorityMap.put(new BigInteger("2"), 2); // Assuming ID is 2
        // Add more mappings as needed...
    }

    // Get all To-Do items
    public List<ToDo> getAllToDoItems() {
        List<ToDo> todoList = new ArrayList<>();
        repo.findAll().forEach(todoList::add);

        // Sort tasks by status and date
        todoList.sort(Comparator.comparing(ToDo::getStatus).thenComparing(ToDo::getDate));

        return todoList;
    }

    // Get To-Do item by ID
    public ToDo getToDoItemById(BigInteger id) {
        return repo.findById(id).orElse(null);  // Handle null case safely
    }

    // Smartly prioritize tasks
    public List<ToDo> smartPrioritizeTasks() {
        List<ToDo> tasks = getAllToDoItems();

        // Custom sorting logic using the priority map
        tasks.sort((t1, t2) -> {
            int priority1 = priorityMap.getOrDefault(t1.getId(), 3); // Default to Low if not found
            int priority2 = priorityMap.getOrDefault(t2.getId(), 3);
            int priorityCompare = Integer.compare(priority1, priority2); // Lower number = higher priority

            // If priorities are equal, sort by date
            if (priorityCompare != 0) return priorityCompare;

            return t1.getDate().compareTo(t2.getDate());
        });

        return tasks;
    }

    // Update task status to "Completed"
    public boolean updateStatus(BigInteger id) {
        ToDo todo = getToDoItemById(id);
        if (todo != null) {
            todo.setStatus("Completed");
            return saveOrUpdateToDoItem(todo);
        }
        return false;
    }

    // Save or update a To-Do item
    public boolean saveOrUpdateToDoItem(ToDo todo) {
        ToDo updatedObj = repo.save(todo);
        return updatedObj != null && getToDoItemById(updatedObj.getId()) != null;
    }

    // Delete a To-Do item by ID
    public boolean deleteToDoItem(BigInteger id) {
        repo.deleteById(id);
        return repo.findById(id).isEmpty();
    }

    // Get today's tasks (Daily Summary)
    public List<ToDo> getTodayTasks() {
        List<ToDo> allTasks = getAllToDoItems();
        List<ToDo> todayTasks = new ArrayList<>();
        Date today = new Date();

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        for (ToDo task : allTasks) {
            cal1.setTime(today);
            cal2.setTime(Task.getLocalDate());

            cal1.set(Calendar.HOUR_OF_DAY, 0);
            cal1.set(Calendar.MINUTE, 0);
            cal1.set(Calendar.SECOND, 0);
            cal1.set(Calendar.MILLISECOND, 0);

            cal2.set(Calendar.HOUR_OF_DAY, 0);
            cal2.set(Calendar.MINUTE, 0);
            cal2.set(Calendar.SECOND, 0);
            cal2.set(Calendar.MILLISECOND, 0);

            if (cal1.getTime().equals(cal2.getTime())) {
                todayTasks.add(task);
            }
        }

        return todayTasks;
    }

    // Get completed tasks
    public List<ToDo> getCompletedTasks() {
        List<ToDo> completedTasks = repo.findCompletedTasks(); // Fetch completed tasks

        // Logic to set time spent could go here
        for (ToDo task : completedTasks) {
            task.setTimeSpent(getTimeSpent(task.getId())); // Add this line
        }
        return completedTasks;
    }

    // Placeholder method for getting time spent
    private int getTimeSpent(BigInteger taskId) {
        // Logic to get time spent for the task, e.g., from the database or calculated
        return 0; // Replace with actual implementation
    }

    // Fetch task details by ID
    public ToDo getTaskDetails(BigInteger id) {
        return getToDoItemById(id); // Reuse the existing method to fetch task details
    }
}
