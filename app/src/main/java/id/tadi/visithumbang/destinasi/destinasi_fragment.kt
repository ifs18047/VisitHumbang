package id.tadi.visithumbang.destinasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import id.tadi.visithumbang.R
import id.tadi.visithumbang.databinding.CustomItemLayout2Binding
import id.tadi.visithumbang.databinding.CustomItemLayoutBinding
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.utils.setImage
import kotlin.random.Random

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class destinasi_fragment: Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    val listFour = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_destinasi, container, false)
        val list = mutableListOf<CarouselItem>()
        val carousel: ImageCarousel = view.findViewById(R.id.carousel4)
        val carousel2: ImageCarousel = view.findViewById(R.id.carousel5)
        val carousel3: ImageCarousel = view.findViewById(R.id.carousel6)
        carousel.registerLifecycle(lifecycle)
        carousel2.registerLifecycle(lifecycle)
        carousel3.registerLifecycle(lifecycle)
        carousel.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                super.onClick(position, carouselItem)
                var fr = getFragmentManager()?.beginTransaction()
                fr?.replace(R.id.fragment_berita, destinasiisi_fragment())
                fr?.commit()
            }

            override fun onCreateViewHolder(
                layoutInflater: LayoutInflater,
                parent: ViewGroup
            ): ViewBinding? {
                return CustomItemLayoutBinding.inflate(
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
                val currentBinding = binding as CustomItemLayoutBinding
                currentBinding.title.text = item.caption ?: "text"
                currentBinding.imageView.apply {
                    scaleType = carousel.imageScaleType
                    setImage(item, R.drawable.c)
                }
            }
        }
        carousel2.carouselListener = object : CarouselListener {
            override fun onCreateViewHolder(
                layoutInflater: LayoutInflater,
                parent: ViewGroup
            ): ViewBinding? {
                return CustomItemLayoutBinding.inflate(
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
                val currentBinding = binding as CustomItemLayoutBinding
                currentBinding.title.text = item.caption ?: "text"
                currentBinding.imageView.apply {

                    scaleType = carousel.imageScaleType

                    setImage(item, R.drawable.c)
                }
            }
        }

        carousel3.carouselListener = object : CarouselListener {
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
        carousel2.setData(list)
        carousel3.setData(list)
        return view

    }

}

