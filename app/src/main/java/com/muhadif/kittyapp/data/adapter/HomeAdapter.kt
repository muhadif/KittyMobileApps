package com.muhadif.kittyapp.data.adapter

import android.content.Context
import android.util.Log
import com.muhadif.kittyapp.data.model.Kitty
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.storage.FirebaseStorage
import com.muhadif.kittyapp.R
import com.muhadif.kittyapp.data.module.GlideApp
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_home.*


class HomeAdapter(
    private val data : List<Kitty>,
    private val storage: FirebaseStorage,
    private val context : Context,
    val listener : (Kitty) -> Unit) : RecyclerView.Adapter<HomeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data[position], storage, context, listener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindData(
            kitty: Kitty,
            storage: FirebaseStorage,
            context: Context,
            listener : (Kitty) -> Unit
        ){
            tv_kitty_name.text = kitty.name

            val gsReference = storage.reference
                .child("kitties")
                .child(kitty.image)

            Log.d("Image", gsReference.toString())
            GlideApp.with(context)
                .load(gsReference)
                .into(iv_kitty)

            itemView.setOnClickListener { listener(kitty) }



        }
    }

}