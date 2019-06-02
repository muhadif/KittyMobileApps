package com.muhadif.kittyapp.fragment.home

import com.muhadif.kittyapp.data.model.Kitty

interface HomeContract {
    interface View {
        fun isLoading(state : Boolean)
        fun showLoad(data : List<Kitty>)
    }
    interface Presenter {
        fun loadData()
    }
}