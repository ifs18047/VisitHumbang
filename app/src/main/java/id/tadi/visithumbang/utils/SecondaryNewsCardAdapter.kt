package id.tadi.visithumbang.utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.tadi.visithumbang.databinding.SecondaryCardBinding
import id.tadi.visithumbang.events.utils.Event

class SecondaryNewsCardAdapter(private val events : ArrayList<Event>) : RecyclerView.Adapter<SecondaryNewsCardAdapter.SecondaryViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Event)
    }

    inner class SecondaryViewHolder(private val binding : SecondaryCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(event : Event){
            binding.scTitle.text = event.eventName
            binding.scDate.text = event.eventDate
            binding.scLocation.text = event.eventLocation
            Glide.with(binding.cardBackground.context)
                .load(event.eventPoster)
                .centerCrop()
                .into(binding.cardBackground)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondaryViewHolder {
        return SecondaryViewHolder(SecondaryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SecondaryViewHolder, position: Int) {
        val event = events[position]
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(event)
        }
        holder.bind(event)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

}