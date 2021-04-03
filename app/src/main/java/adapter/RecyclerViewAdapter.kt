package adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.votify.R


class RecyclerViewAdapter(
        private var pollsList:Array<String>,  //Change type of data according to retrived data
        private val listener : onPollItemClickListener //pollsList contains list of polls available to user
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.poll_card,parent,false)//poll_card is design of card to be displayed xml file
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pollsList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.pollNameText.text = pollsList[position]
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val pollNameText:TextView
        init{
            pollNameText=itemView.findViewById(R.id.pollName)
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position:Int=adapterPosition
            if(position!=RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface onPollItemClickListener{
        fun onItemClick(position:Int)
    }

}