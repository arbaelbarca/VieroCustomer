package com.cindodcindy.vieroshoesnew.view.activity

import android.os.Bundle
import com.cindodcindy.vieroshoesnew.R
import com.cindodcindy.vieroshoesnew.basedata.BaseActivity
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initial()
    }

    private fun initial() {
        val getNama = Hawk.get<String>("namaProfile")
        val getEmail = Hawk.get<String>("emailProfile")

        tvEmailProfile.text = getEmail
        tvNameProfile.text = getNama

    }
}