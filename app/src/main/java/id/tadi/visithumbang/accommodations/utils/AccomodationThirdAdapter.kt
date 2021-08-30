package id.tadi.visithumbang.accommodations.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.tadi.visithumbang.databinding.ThirdCardBinding

class AccomodationThirdAdapter(private val hotels : ArrayList<Accommodation>) : RecyclerView.Adapter<AccomodationThirdAdapter.ThirdViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Accommodation)
    }

    inner class ThirdViewHolder(private val binding : ThirdCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(hotel : Accommodation){
            binding.tcTitle.text = hotel.accommodationName
            binding.tcLocation.text = hotel.accommodationLocation
            Glide.with(binding.thirdCardBackground.context)
                .load(hotel.accommodationPoster)
                .centerCrop()
                .into(binding.thirdCardBackground)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThirdViewHolder {
        return ThirdViewHolder(ThirdCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ThirdViewHolder, position: Int) {
        val hotel = hotels[position]
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(hotel)
        }
        holder.bind(hotel)
    }

    override fun getItemCount(): Int {
        return hotels.size
    }
}