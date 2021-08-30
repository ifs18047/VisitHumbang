package id.tadi.visithumbang.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.tadi.visithumbang.databinding.ImageCarouselBinding

class CarouselAdapter(private val images : ArrayList<String>) : RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {
    inner class CarouselViewHolder(private val binding : ImageCarouselBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(image : String){
            Glide.with(
                binding.root.context
            )
                .load(image)
                .centerCrop()
                .into(binding.ivImageCarousel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        return CarouselViewHolder(
            ImageCarouselBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int = 4
}