package com.example.SchedulEase.SchedulEaseController;

import com.example.SchedulEase.model.ToDo;
import com.example.SchedulEase.service.ToDoService;
import com.example.SchedulEase.repo.IToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.SchedulEase.model.ToDo.Task;
import java.math.BigInteger;
import java.util.List;

@Controller
public class SchedulEaseController {

    @Autowired
    private ToDoService service;

    @Autowired // Added this line to autowire the repo
    private IToDoRepo repo;

    @GetMapping({"/", "viewToDoList"})
    public String viewAllToDoItems(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("list", service.getAllToDoItems());
        model.addAttribute("message", message);
        return "ViewToDoList";
    }

    @GetMapping("/updateToDoStatus/{id}")
    public String updateToDoStatus(@PathVariable BigInteger id, RedirectAttributes redirectAttributes) {
        if (service.updateStatus(id)) {
            redirectAttributes.addFlashAttribute("message", "Update Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Update Failure");
        }
        return "redirect:/viewToDoList";
    }

    @GetMapping("/addToDoItem")
    public String addToDoItem(Model model) {
        model.addAttribute("todo", new ToDo());
        return "AddToDoItem";
    }

    @PostMapping("/saveToDoItem")
    public String saveToDoItem(ToDo todo, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdateToDoItem(todo)) {
            redirectAttributes.addFlashAttribute("message", "Save Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Save Failure");
            return "redirect:/addToDoItem"; // Redirect if save fails
        }
        return "redirect:/viewToDoList";
    }

    @GetMapping("/editToDoItem/{id}")
    public String editToDoItem(@PathVariable BigInteger id, Model model) {
        model.addAttribute("todo", service.getToDoItemById(id));
        return "EditToDoItem";
    }

    @PostMapping("/editSaveToDoItem")
    public String editSaveToDoItem(ToDo todo, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdateToDoItem(todo)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Edit Failure");
            return "redirect:/editToDoItem/" + todo.getId(); // Redirect if edit fails
        }
        return "redirect:/viewToDoList";
    }

    @GetMapping("/deleteToDoItem/{id}")
    public String deleteToDoItem(@PathVariable BigInteger id, RedirectAttributes redirectAttributes) {
        if (service.deleteToDoItem(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }
        return "redirect:/viewToDoList";
    }

    @GetMapping("/dailySummary")
    public String getTodayTasks(Model model) {
        List<ToDo> todayTasks = service.getTodayTasks();
        model.addAttribute("list", todayTasks);
        return "DailySummary"; // Return the JSP view name
    }

    @GetMapping("/smartPrioritizedTasks")
    public String viewSmartPrioritizedTasks(Model model) {
        List<ToDo> prioritizedTasks = service.smartPrioritizeTasks();
        model.addAttribute("list", prioritizedTasks);
        return "ViewPrioritizedTasks"; // Make sure you have this JSP
    }

    @GetMapping("/viewCompletedTasks")
    public String getCompletedTasks(Model model) {
        List<ToDo> completedTasks = service.getCompletedTasks(); // Fetch completed tasks
        model.addAttribute("completedTasks", completedTasks);
        return "ViewCompletedTasks"; // Replace with your actual JSP view name
    }


    // Placeholder method for getting time spent
    private int getTimeSpent(BigInteger taskId) {
        // Logic to get time spent for the task, e.g., from the database or calculated
        return 0; // Replace with actual implementation
    }

    @GetMapping("/taskDetails")
    public String taskDetails(@RequestParam("id") BigInteger id, Model model) {
        ToDo Task = service.getTaskDetails(id); // Corrected access to service method
        model.addAttribute("task", Task);
        return "taskDetails"; // JSP file name without .jsp
    }
}
