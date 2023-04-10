package com.example.whatsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class fragmentchat_message : Fragment() {
    var recyclerView: RecyclerView? = null
    var adapter: MyRecyclerViewAdapter? = null
    var userList: MutableList<String?> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmentchat_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycleViewList)
        setData()
    }

    private fun setData() {
        userList.add("Jaimil")
        userList.add("Praful Bhai")
        userList.add("Dad")
        userList.add("Keyur Parmar")
        userList.add("Jaydip parmar")
        userList.add("Dhruv Rabari")
        userList.add("Tejas Tadvi")
        adapter = MyRecyclerViewAdapter(activity, userList)
        recyclerView!!.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerView!!.adapter = adapter
    }
}