package com.example.my_start_application

import android.graphics.Paint
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ToDoAdapter (
    private val todos:MutableList<Todo>
        ) :RecyclerView.Adapter<ToDoAdapter.TodoViewHolder>(){
         class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_to_do,
                parent,false)
        )
    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo=todos[position]
        holder.itemView.apply{
            val tvToDoTitle : TextView = findViewById(R.id.tvToDoTitle)
            val cbDone: CheckBox = this.findViewById(R.id.cbToDo)
            tvToDoTitle.text = curTodo.title
            cbDone.isChecked = curTodo.isChecked
            checkbox(tvToDoTitle,curTodo.isChecked)
            cbDone.setOnCheckedChangeListener { _, isChecked ->
                checkbox(tvToDoTitle, isChecked)
                curTodo.isChecked=!curTodo.isChecked

            }
        }

    }
    override fun getItemCount(): Int {
       return todos.size
    }
    fun addToDo(todo: Todo){
        todos.add(todo)
        notifyItemInserted(todos.size-1)
        println("add to do")

    }
    fun deleteToDo()
    {
        todos.removeAll{
            todo -> todo.isChecked
        }
        notifyDataSetChanged()
    }
    private fun checkbox(tvToDoTitle: TextView ,isChecked:Boolean){
        if(isChecked)
        {tvToDoTitle.paintFlags=tvToDoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG

        }
        else
        {
            tvToDoTitle.paintFlags=tvToDoTitle.paintFlags and  STRIKE_THRU_TEXT_FLAG.inv()
        }

    }



}