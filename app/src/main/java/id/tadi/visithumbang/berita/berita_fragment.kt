package id.tadi.visithumbang.berita

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import id.tadi.visithumbang.R
import id.tadi.visithumbang.databinding.CustomItemLayout3Binding
import org.imaginativeworld.whynotimagecarousel.*
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.utils.setImage
import id.tadi.visithumbang.berita.databerita

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class berita_fragment: Fragment() {
    private var list: ArrayList<berita> = arrayListOf()
    private lateinit var Adapter: beritaadapter
    private var param1: String? = null
    private var param2: String? = null

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
        val view: View = inflater.inflate(R.layout.fragment_berita, container, false)
        val list = mutableListOf<CarouselItem>()
        val carousel: ImageCarousel = view.findViewById(R.id.carousel7)

        carousel.registerLifecycle(lifecycle)
        carousel.carouselListener = object : CarouselListener {
            override fun onCreateViewHolder(
                layoutInflater: LayoutInflater,
                parent: ViewGroup
            ): ViewBinding? {
                return CustomItemLayout3Binding.inflate(
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
                val currentBinding = binding as CustomItemLayout3Binding

                currentBinding.newsTitle.text = item.caption ?: "News Title"
                currentBinding.newsDate.text = item.caption ?: "News Date"


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