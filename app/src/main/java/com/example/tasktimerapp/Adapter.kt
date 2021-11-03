package com.example.tasktimerapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktimerapp.RoomDB.TasksTable
import com.example.tasktimerapp.databinding.ItemRowBinding

class Adapter(val activity:ViewTask, val TaskList:List<TasksTable>): RecyclerView.Adapter<Adapter.ItemBinding>() {
    class ItemBinding (val bin :ItemRowBinding):RecyclerView.ViewHolder(bin.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBinding {
        return ItemBinding(ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: ItemBinding, position: Int) {
        val TaskObj=TaskList[position]
        val TaskId=TaskList[position].id
        val TaskName=TaskList[position].name
        val TaskDes=TaskList[position].discrption
        val TaskTime=TaskList[position].time

        holder.bin.apply {
            tvTaskNameRV.text=TaskName

            FABtimer.setOnClickListener(){
                activity.intent= Intent(activity,Timer::class.java)
                activity.intent.putExtra("taskID", TaskId)
                activity.startActivity(activity.intent)
            }//end listener

            if (activity.isBtnSumarryClick){
                activity.btnSummaryTask.visibility= View.INVISIBLE
                if (TaskTime.isNotEmpty()){
                    tvTaskTimeRVD.visibility= View.VISIBLE
                    FABtimer.visibility= View.GONE
                    tvTaskTimeRVD.text=TaskTime
                }else{
                    FABtimer.visibility= View.VISIBLE
                    tvTaskTimeRVD.visibility= View.GONE
                }
            }else
            {
                activity.btnSummaryTask.visibility= View.VISIBLE
            }//end if

        }//end holder

    }//end onBindViewHolder()

    override fun getItemCount(): Int = TaskList.size
}