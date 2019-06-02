package com.muhadif.kittyapp.ui.detail

import com.muhadif.kittyapp.data.model.Kitty

interface DetailContract {
    interface View{
        fun isLoading(state : Boolean)
        fun loadData(kitty : Kitty)
    }

    interface Presenter{
        fun getData(kittyId : String)
    }
}