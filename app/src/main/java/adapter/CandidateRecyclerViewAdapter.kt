package adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.votify.R


class CandidateRecyclerViewAdapter(
        private var candidateList:Array<String>) : RecyclerView.Adapter<CandidateRecyclerViewAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidateRecyclerViewAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.candidate_card,parent,false)//poll_card is design of card to be displayed xml file
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return candidateList.size
    }

    override fun onBindViewHolder(holder: CandidateRecyclerViewAdapter.ViewHolder, position: Int) {
        holder.candidateNameText.text = candidateList[position]
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val candidateNameText:TextView
        init{
            candidateNameText=itemView.findViewById(R.id.candidateName)
        }

    }
}