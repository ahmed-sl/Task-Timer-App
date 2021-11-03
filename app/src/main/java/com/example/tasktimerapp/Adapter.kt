package com.example.tasktimerapp

import android.content.Intent
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktimerapp.RoomDB.TasksTable
import com.example.tasktimerapp.databinding.ItemRowBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

        var running = false
        var pauseOffset: Long = 0
        var taskTime=""

        holder.bin.apply {
            tvTaskNameRV.text=TaskName

            FABtimer.setOnClickListener(){
                LL1RV.visibility=View.GONE
                LL2RV.visibility=View.VISIBLE
                tvTaskNameTimer.text=TaskName
                tvTaskDescriptionTimer.text=TaskDes
                activity.Timer(chronometer)

            }//end listener

            startbutton.setOnClickListener {
                activity.start(chronometer,TaskName)
            }


            pausebutton.setOnClickListener {
                if (activity.pasuse(chronometer,TaskId))
                    LL1RV.visibility=View.VISIBLE
                    LL2RV.visibility=View.GONE
            }

            LL2RV.setOnClickListener(){
                LL1RV.visibility=View.VISIBLE
                LL2RV.visibility=View.GONE
            }

            //go to summary part
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