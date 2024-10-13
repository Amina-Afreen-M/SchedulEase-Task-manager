package com.example.SchedulEase.model;

import java.time.LocalDate;
import java.math.BigInteger;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "ToDo")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column
    private String title;

    @Column
    private LocalDate date; // Changed to LocalDate for better date handling

    @Column
    private String status;

    @Column
    private int timeSpent; // Field for time spent on the task

    // Default constructor
    public ToDo() {}

    // Getters and Setters for ToDo class
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    // LearningGoal class definition
    @Entity
    @Table(name = "LearningGoal")
    public static class LearningGoal {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private BigInteger id;

        @Column
        private String goalName;

        @Column
        private int totalMilestones;

        @Column
        private int milestonesCompleted;

        // Default constructor
        public LearningGoal() {}

        // Getters and Setters for LearningGoal class
        public BigInteger getId() {
            return id;
        }

        public void setId(BigInteger id) {
            this.id = id;
        }

        public String getGoalName() {
            return goalName;
        }

        public void setGoalName(String goalName) {
            this.goalName = goalName;
        }

        public int getTotalMilestones() {
            return totalMilestones;
        }

        public void setTotalMilestones(int totalMilestones) {
            this.totalMilestones = totalMilestones;
        }

        public int getMilestonesCompleted() {
            return milestonesCompleted;
        }

        public void setMilestonesCompleted(int milestonesCompleted) {
            this.milestonesCompleted = milestonesCompleted;
        }
    }

    // Task class definition
    @Entity
    @Table(name = "Task")
    public static class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private BigInteger id;

        @Column
        private String description;

        @Column
        private static LocalDate date;

        @Column
        private String status;

        @Column
        private int timeSpent; // Field for time spent on the task

        // Default constructor
        public Task() {}

        public static Date getLocalDate() {
            return new Date();
        }

        // Getters and Setters for Task class
        public BigInteger getId() {
            return id;
        }

        public void setId(BigInteger id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public static LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getTimeSpent() {
            return timeSpent;
        }

        public void setTimeSpent(int timeSpent) {
            this.timeSpent = timeSpent;
        }
    }
}
