package com.example.my_start_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter:ToDoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        println("heeeyyyyy")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = ToDoAdapter(mutableListOf())
        val rvTodoItems : RecyclerView = findViewById(R.id.recyclerView)
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)
        val btnAddTodo : Button = findViewById(R.id.btnAddToDo)
        val etTodoTitle : EditText = findViewById(R.id.etTodotile)
        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addToDo(todo)
                etTodoTitle.text.clear()
            }
        }
        val btnDeleteDoneTools : Button = findViewById(R.id.btnToDelete)
        btnDeleteDoneTools.setOnClickListener {
            todoAdapter.deleteToDo()
        }
    }
}