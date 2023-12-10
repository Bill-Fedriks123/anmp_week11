package com.example.advweek4_160420084.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4_160420084.R
import com.example.advweek4_160420084.databinding.StudentListItemBinding
import com.example.advweek4_160420084.model.Student
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studentList: ArrayList<Student>) : RecyclerView.
Adapter<StudentListAdapter.StudentViewHolder>(),
 ButtonDetailClickListener,
ButtonUpdateClickListener,
ButtonCreateNotifClickListener{
    class StudentViewHolder(var view: StudentListItemBinding):
            RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.student_list_item, parent, false)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater, R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount() = studentList.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        /*holder.view.textID.text = studentList[position].id
        holder.view.textName.text = studentList[position].name
        holder.view.buttonDetail.setOnClickListener {
            val action = StudentsListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }*/
        holder.view.student = studentList[position]
        holder.view.listener = this
    }
    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentsListFragmentDirections.actionStudentDetail()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonUpdateClick(v: View) {
        val action = StudentsListFragmentDirections.actionStudentDetail()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonCreateNotif(v: View) {
        val action = StudentsListFragmentDirections.actionStudentDetail()
        Navigation.findNavController(v).navigate(action)
    }
}