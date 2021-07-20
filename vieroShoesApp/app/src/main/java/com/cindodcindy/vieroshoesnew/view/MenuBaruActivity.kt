package com.cindodcindy.vieroshoesnew.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cindodcindy.vieroshoesnew.R
import com.cindodcindy.vieroshoesnew.view.activity.AboutActivity
import com.cindodcindy.vieroshoesnew.view.activity.ProductActivity
import com.cindodcindy.vieroshoesnew.view.activity.ProfileActivity
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_menu_baru.*

class MenuBaruActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_baru)

        cv_go_to_list_sepatu.setOnClickListener { v: View? ->
            val intent = Intent(this@MenuBaruActivity, ProductActivity::class.java)
            startActivity(intent)
        }
        cv_go_to_order.setOnClickListener { v: View? ->
            val intent = Intent(this@MenuBaruActivity, OrderActivity::class.java)
            startActivity(intent)
        }
        cv_go_to_payment.setOnClickListener { v: View? ->
            val intent = Intent(this@MenuBaruActivity, PaymentListActivity::class.java)
            startActivity(intent)
        }

        cardViewProfile.setOnClickListener {
            val intent = Intent(this@MenuBaruActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        cardViewAbout.setOnClickListener {
            val intent = Intent(this@MenuBaruActivity, AboutActivity::class.java)
            startActivity(intent)
        }

        cardViewLogout.setOnClickListener {
            val intent = Intent(this@MenuBaruActivity, Login::class.java)
            startActivity(intent)
            Hawk.deleteAll()
            finish()
        }
    }
}