package com.muhadif.kittyapp.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.muhadif.kittyapp.R
import com.muhadif.kittyapp.data.model.Kitty
import com.muhadif.kittyapp.data.module.GlideApp
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.iv_kitty
import kotlinx.android.synthetic.main.activity_detail.tv_description
import kotlinx.android.synthetic.main.item_home.*


fun Context.KittyDetailIntent(kitty: Kitty): Intent {
    return Intent(this, DetailActivity::class.java).apply {
        putExtra(INTENT_KITTY_ID, kitty.id)
    }
}

private const val INTENT_KITTY_ID = "kitty_id"

class DetailActivity : AppCompatActivity(), DetailContract.View {
    lateinit var database : FirebaseFirestore

    lateinit var storage : FirebaseStorage
    lateinit var presenter: DetailPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val kittyId = intent.getStringExtra(INTENT_KITTY_ID)

        database = FirebaseFirestore.getInstance()
        storage = FirebaseStorage.getInstance()

        presenter = DetailPresenter(this, database)
        presenter.getData(kittyId)

    }

    override fun isLoading(state: Boolean) {

    }

    override fun loadData(kitty: Kitty) {
        title = kitty.name

        tv_description.text = kitty.description

        val gsReference = storage.reference
            .child("kitties")
            .child(kitty.image)


        GlideApp.with(this)
            .load(gsReference)
            .into(iv_kitty)
    }
}
