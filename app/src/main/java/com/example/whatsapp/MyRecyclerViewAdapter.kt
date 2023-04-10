package com.example.whatsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private var recycleviewInterface: RecycleviewInterface? = null
    private var mData: List<String>? = null
    private var mInflater: LayoutInflater? = null
    private var mClickListener: ItemClickListener? = null
    private val textView: TextView? = null
    private val imageView: ImageView? = null

    // data is passed into the constructor
    constructor(
        context: Context?,
        data: List<String>?,
        recycleviewInterface: RecycleviewInterface?,
        recycleviewInterface1: RecycleviewInterface?
    ) {
        mInflater = LayoutInflater.from(context)
        mData = data
        this.recycleviewInterface = recycleviewInterface1
    }

    constructor(activity: FragmentActivity?, userList: List<String?>?) {}

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater!!.inflate(R.layout.row_item_contact, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = mData!![position]
        holder.myTextView.text = animal
    }

    // total number of rows
    override fun getItemCount(): Int {
        return mData!!.size
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var myTextView: TextView
        var imageView: ImageView

        init {
            myTextView = itemView.findViewById(R.id.txtUsername)
            imageView = itemView.findViewById(R.id.imgUser)
            itemView.setOnClickListener {
                if (recycleviewInterface != null) {
                    val pos = adapterPosition
                    if (pos != RecyclerView.NO_POSITION) {
                        recycleviewInterface!!.onItemclick(pos)
                    }
                }
            }
        }

        override fun onClick(view: View) {
            if (mClickListener != null) mClickListener!!.onItemClick(view, adapterPosition)
        }
    }

    // convenience method for getting data at click position
    fun getItem(id: Int): String {
        return mData!![id]
    }

    // allows clicks events to be caught
    fun setClickListener(itemClickListener: ItemClickListener?) {
        mClickListener = itemClickListener
    }

    // parent activity will implement this method to respond to click events
    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }
}