package com.addie.expense_tracker.repository;

import com.addie.expense_tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByCategory(String category);

    List<Expense> findByDate(LocalDate date);

    @Query("SELECT SUM(e.amount) FROM Expense e")
    Double getTotalExpenses();
}