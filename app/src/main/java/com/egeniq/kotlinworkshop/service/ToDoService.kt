package com.egeniq.kotlinworkshop.service

import com.egeniq.kotlinworkshop.model.ToDoItem

/**
 * Created by ruben on 25/04/2017.
 */
object ToDoService {
    private val todoItems = mutableListOf<ToDoItem>()

    init {
        todoItems.add(ToDoItem("1", "Find out something about Kotlin",null))
        todoItems.add(ToDoItem("2", "Think that Kotlin is stupid", "And it's just a hype that will pass away"))
        todoItems.add(ToDoItem("3", "Learn to know Kotlin", "And understand it can be very awesome"))
        todoItems.add(ToDoItem("4", "Have a great pizza break", "With some nice discussions"))
        todoItems.add(ToDoItem("5", "Build cool apps at Egeniq","With the help of Kotlin!"))
        todoItems.add(ToDoItem("6", "Never think back about the grey days of Java 6", null))
    }


    /**
     * Just returns the list we created in the constructor
     */
    fun getTodoList(): MutableList<ToDoItem> = todoItems

    /**
     * Add an item to the list
     */
    fun addOrUpdateItem(item: ToDoItem) {
        todoItems.indexOfFirst { it -> it.id == item.id }
                .let { it ->
                    if (it >= 0) {
                        todoItems[it] = item
                    } else {
                        todoItems.add(item)
                    }
                }
    }

    fun deleteTodoItem(position: Int) {
        if (position >= 0 && position < todoItems.size) {
            todoItems.removeAt(position)
        }
    }
}