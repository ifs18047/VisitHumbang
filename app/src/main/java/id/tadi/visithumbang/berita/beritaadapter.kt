package id.tadi.visithumbang.berita

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.tadi.visithumbang.R

class beritaadapter(private val listberita: ArrayList<berita> ): RecyclerView.Adapter<beritaadapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): beritaadapter.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false))

    override fun onBindViewHolder(holder: beritaadapter.ViewHolder, position: Int) = holder.bind(listberita[position])

    override fun getItemCount(): Int = listberita.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(berita: berita){

        }
    }

}