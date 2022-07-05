package com.example.myapplication.app.adapter

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.local.DocumentEntity
import com.example.myapplication.data.local.ECommerceEntity
import java.lang.Exception

class DocAdapter : RecyclerView.Adapter<DocAdapter.ViewHolder>() {
    var list: List<DocumentEntity>? = null
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_document, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list?.get(position)?.name_uz ?: ""
        holder.layout.setOnClickListener {
            val url = list?.get(position)?.url ?: ""
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            try {
                it.context.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(it.context, "Browser not found", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount() = list?.size ?: 0

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout: View = itemView.findViewById(R.id.layout)
        val title: TextView = itemView.findViewById(R.id.textTitle)

    }
}