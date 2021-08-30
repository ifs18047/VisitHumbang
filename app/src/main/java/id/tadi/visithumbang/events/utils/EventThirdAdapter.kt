package id.tadi.visithumbang.events.utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.tadi.visithumbang.databinding.ThirdCardBinding

class EventThirdAdapter(private val events : ArrayList<Event>) : RecyclerView.Adapter<EventThirdAdapter.ThirdViewHolder>() {

    inner class ThirdViewHolder(private val binding : ThirdCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(event : Event){
            binding.tcTitle.text = event.eventName
            binding.tcTitle.setTextColor(Color.WHITE)
            binding.tcLocation.text = event.eventLocation
            binding.tcLocation.setTextColor(Color.WHITE)
            Glide.with(binding.thirdCardBackground.context)
                .load(event.eventPoster)
                .centerCrop()
                .into(binding.thirdCardBackground)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThirdViewHolder {
        return ThirdViewHolder(ThirdCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ThirdViewHolder, position: Int) {
        val event = events[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int {
        return events.size
    }

}