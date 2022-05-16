package com.ib.retrofitroomrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ib.retrofitroomrecyclerview.adapter.MyAdapter
import com.ib.retrofitroomrecyclerview.model.RecyclerList
import com.ib.retrofitroomrecyclerview.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_recycler_list.view.*

class RecyclerListFragment : Fragment() {
    lateinit var myAdapter: MyAdapter
    //lateinit var myViewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_recycler_list, container, false)
        initRecyclerView(view)
        initViewModel()
        return view
    }

    private fun initViewModel() {
       val myViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        myViewModel.getRecyclerListObserver().observe(viewLifecycleOwner, Observer{
if (it != null){
    myAdapter.setUpdatedData(it.items)
}else{
    Toast.makeText(activity, "try again", Toast.LENGTH_LONG).show()
}
        })
        myViewModel.makeApiCall()
    }

    private fun initRecyclerView(view: View) {
        val recyclerView = view.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this.activity)
        val decoration = DividerItemDecoration(activity,DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)
        myAdapter = MyAdapter()
        recyclerView.adapter = myAdapter
    }


}