package com.muhadif.kittyapp.fragment.home


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

import com.muhadif.kittyapp.R
import com.muhadif.kittyapp.data.adapter.HomeAdapter
import com.muhadif.kittyapp.data.model.Kitty
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), HomeContract.View {

    companion object {
        fun getInstrance() : HomeFragment =
            HomeFragment()
    }

    lateinit var database : FirebaseFirestore
    lateinit var storage : FirebaseStorage
    lateinit var presenter: HomePresenter
    lateinit var adapter : HomeAdapter
    lateinit var linearLayoutManager : LinearLayoutManager
    private var kities : MutableList<Kitty> = mutableListOf()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = FirebaseFirestore.getInstance()
        storage = FirebaseStorage.getInstance()

        presenter = HomePresenter(this, database)

        presenter.loadData()

        adapter = HomeAdapter(kities, storage, context!!) {
            Toast.makeText(context, "Hello ${it.name}", Toast.LENGTH_SHORT ).show()
            Log.d("ITEM", "CLICKED")
        }

        setRecycleView()


    }

    override fun isLoading(state: Boolean) {

    }

    override fun showLoad(data: List<Kitty>) {
        Log.d("DATA", "DAta ${data.size}")

        kities.clear()
        kities.addAll(data)

        adapter.notifyDataSetChanged()
    }

    private fun setRecycleView() {
        linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = RecyclerView.VERTICAL

        rv_home.layoutManager = linearLayoutManager
        rv_home.adapter = adapter
    }
}
