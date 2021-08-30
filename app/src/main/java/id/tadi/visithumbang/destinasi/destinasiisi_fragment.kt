package id.tadi.visithumbang.destinasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import id.tadi.visithumbang.R
import id.tadi.visithumbang.databinding.CustomItemLayout2Binding
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.utils.setImage

class destinasiisi_fragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_destinasi_isi, container, false)
        val list = mutableListOf<CarouselItem>()
        val carousel: ImageCarousel = view.findViewById(R.id.carousel6)
        carousel.registerLifecycle(lifecycle)
        carousel.carouselListener = object : CarouselListener {
            override fun onCreateViewHolder(
                layoutInflater: LayoutInflater,
                parent: ViewGroup
            ): ViewBinding? {
                return CustomItemLayout2Binding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            }

            override fun onBindViewHolder(
                binding: ViewBinding,
                item: CarouselItem,
                position: Int
            ) {
                val currentBinding = binding as CustomItemLayout2Binding

                currentBinding.title.text = item.caption ?: "text"
                currentBinding.imageView.apply {

                    scaleType = carousel.imageScaleType

                    setImage(item, R.drawable.c)
                }
            }
        }
        list.add(
            CarouselItem(
                imageDrawable = R.drawable.c
            )
        )
        list.add(
            CarouselItem(
                imageUrl = "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"
            )
        )
        carousel.setData(list)
        return view

    }

}