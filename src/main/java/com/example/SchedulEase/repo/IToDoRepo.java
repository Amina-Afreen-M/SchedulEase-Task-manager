package com.example.SchedulEase.repo;

import com.example.SchedulEase.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface IToDoRepo extends JpaRepository<ToDo, BigInteger> {
    List<ToDo> findByStatus(String status); // Fetch tasks by status

    // New method to fetch completed tasks
    default List<ToDo> findCompletedTasks() {
        return findByStatus("Completed");
    }
}
