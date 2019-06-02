package com.muhadif.kittyapp.fragment.home

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.muhadif.kittyapp.data.model.Kitty

class HomePresenter(
    val view : HomeContract.View,
    val database: FirebaseFirestore
) : HomeContract.Presenter {

    override fun loadData() {

        var kities : MutableList<Kitty> = mutableListOf()


        val documentReference = database.collection("kities")
            .get()

        documentReference.addOnSuccessListener { results ->

            kities.clear()

            for (result in results){

                val kitty = Kitty(
                    name = result["name"].toString(),
                    description = result["description"].toString(),
                    image = result["image"].toString(),
                    species = result["species"].toString()
                )

                kities.add(kitty)

            }

            view.showLoad(kities)

        }.addOnFailureListener{
            Log.d("ERRORTL", "Error ${it}")
        }



    }

}