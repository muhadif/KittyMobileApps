package com.muhadif.kittyapp

<<<<<<< HEAD
import android.os.Bundle
import android.util.Log
=======
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.SearchView
>>>>>>> commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.FirebaseApp
<<<<<<< HEAD
import com.muhadif.kittyapp.fragment.home.HomeFragment

class MainActivity : AppCompatActivity() {

=======
import com.muhadif.kittyapp.fragment.about_us.AboutUsFragment
import com.muhadif.kittyapp.fragment.home.HomeFragment
import com.muhadif.kittyapp.fragment.tips.TipsFragment

class MainActivity : AppCompatActivity() {
lateinit var searchBar : SearchView
>>>>>>> commit

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                changeFragment(0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {


                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

<<<<<<< HEAD
=======
 fun setUrl(url:String){
     searchBar.setQuery(url,false)
 }

>>>>>>> commit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        FirebaseApp.initializeApp(this)


        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        navView.menu.getItem(0).setChecked(true)
        changeFragment(0)

<<<<<<< HEAD
=======
        //transparant status bar
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
//        setupGoogleApiClient()
//        AWSMobileClient.getInstance().initialize(this).execute()
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
>>>>>>> commit
    }

    private fun changeFragment(id : Int){

        lateinit var fragment : Fragment

        Log.d("FRAGMENT", "BERANDA ${id}")

        when(id){
            0 -> fragment = HomeFragment.getInstrance()
<<<<<<< HEAD
        }

        var transition = supportFragmentManager.beginTransaction()

        transition.replace(R.id.fl_home, fragment).commit()
    }

=======
            1 -> fragment = AboutUsFragment.getInstrance()
            2 -> fragment = TipsFragment.getInstrance()

        }

        var transition = supportFragmentManager.beginTransaction()
        transition.replace(R.id.fl_home, fragment).commit()
    }
>>>>>>> commit
}
