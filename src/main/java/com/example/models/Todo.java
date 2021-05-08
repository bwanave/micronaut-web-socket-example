package com.example.models;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Todo {

    private String name;
    private String description;
    private ZonedDateTime targetDate;

    public Todo() {
    }

    public Todo(String name, String description, ZonedDateTime targetDate) {
        this.name = name;
        this.description = description;
        this.targetDate = targetDate;
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

    public ZonedDateTime getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(ZonedDateTime targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(name, todo.name) && Objects.equals(description, todo.description) && Objects.equals(targetDate, todo.targetDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, targetDate);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                '}';
    }
}
