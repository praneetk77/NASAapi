package com.example.kotlinpractice.View

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinpractice.Model.Info
import com.example.kotlinpractice.Model.NASApicture
import com.example.kotlinpractice.R

class MyAdapter(val context : Context, var pictures : ArrayList<Info>) : RecyclerView.Adapter<MyAdapter.myViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_view,parent,false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pictures.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        Log.d("adapter","data set")
        val post = pictures[position]
        holder.title.text = post.title
        holder.date.text = post.body
//        val picture = pictures[position]
//        holder.title.text = picture.title
//        holder.date.text = picture.date
//        Glide.with(context)
//            .load(picture.url)
//            .into(holder.image)
//
//        holder.itemView.setOnClickListener(View.OnClickListener {
//            val intent = Intent(context, MainActivity2::class.java)
//            intent.putExtra("title",picture.title)
//            intent.putExtra("date",picture.date)
//            intent.putExtra("explanation",picture.explanation)
//            intent.putExtra("url",picture.url)
//            context.startActivity(intent)
//        })
    }

    fun setData(plist: ArrayList<Info>) {
        this.pictures = plist
        notifyDataSetChanged()
    }

    class myViewHolder(item_view : View) : RecyclerView.ViewHolder(item_view) {
        val date = item_view.findViewById<TextView>(R.id.date)
        val image = item_view.findViewById<ImageView>(R.id.image)
        val title : TextView = item_view.findViewById(R.id.title)
    }

}