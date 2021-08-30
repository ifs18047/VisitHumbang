package id.tadi.visithumbang.accommodations.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.tadi.visithumbang.databinding.PrimaryCardBinding

class AccommodationsPrimaryAdapter(private val hotels : ArrayList<Accommodation>) : RecyclerView.Adapter<AccommodationsPrimaryAdapter.PrimaryViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Accommodation)
    }

    inner class PrimaryViewHolder(private val binding : PrimaryCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(hotel : Accommodation){
            binding.pcTitle.text = hotel.accommodationName
            binding.pcLocation.text = hotel.accommodationLocation
            Glide.with(binding.pcCardBackground.context)
                .load(hotel.accommodationPoster)
                .centerCrop()
                .into(binding.pcCardBackground)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrimaryViewHolder {
        return PrimaryViewHolder(PrimaryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PrimaryViewHolder, position: Int) {
        val hotel = hotels[position]
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(hotel)
        }
        holder.bind(hotel)
    }

    override fun getItemCount(): Int {
        return hotels.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
}