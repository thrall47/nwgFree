package com.nwg.newworlduide

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdpater(val activity: Activity, val articles: List<Article>?)
    : RecyclerView.Adapter<NewsAdpater.NewsViewHolder>() {
    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.tv_news)
        val image: ImageView = view.findViewById(R.id.iv_news)
        val parent: CardView = view.findViewById(R.id.parent)
        val date: TextView = view.findViewById(R.id.date)
        val title: TextView = view.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdpater.NewsViewHolder {
        val view = activity.layoutInflater.inflate(R.layout.list_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdpater.NewsViewHolder, position: Int) {
        holder.text.text = articles?.get(position)?.content
        holder.date.text = articles?.get(position)?.posted_at


        val nullTitle = articles?.get(position)?.title

        if (nullTitle != null){
            holder.title.text = articles?.get(position)?.title
        }

        if (nullTitle == null){
            holder.title.text = "New Updates"
        }



        val pictures = articles?.get(position)?.image_url

        if (pictures != null){
            Glide
                .with(activity)
                .load(pictures)
                .into(holder.image)
        }
        if (pictures == null){

                holder.image.setImageResource(R.drawable.imagedefault)

        }


        holder.parent.setOnClickListener {
            val link = Uri.parse(articles?.get(position)?.source_url)
            val intent = Intent(Intent.ACTION_VIEW, link)
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = articles?.size ?: 0
}