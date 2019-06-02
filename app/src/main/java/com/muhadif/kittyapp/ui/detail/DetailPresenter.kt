package com.muhadif.kittyapp.ui.detail

import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.muhadif.kittyapp.data.model.Kitty

class DetailPresenter(
    val view : DetailContract.View,
    val database: FirebaseFirestore
) : DetailContract.Presenter{
    override fun getData(kittyId: String) {

        val documentReference = database.collection("kities")
            .document(kittyId)
            .get()

        documentReference.addOnCompleteListener {
            if(it.isSuccessful){
                val document = it.result!!
                if(document != null) {
                    val kitty = Kitty(
                        id = document.id,
                        name = document["name"].toString(),
                        description = document["description"].toString(),
                        image = document["image"].toString(),
                        species = document["species"].toString()
                    )
                    view.loadData(kitty)
                }
            }
        }

    }

}