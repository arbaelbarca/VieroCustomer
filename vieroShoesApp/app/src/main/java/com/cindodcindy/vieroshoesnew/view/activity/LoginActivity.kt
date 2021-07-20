package com.cindodcindy.vieroshoesnew.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.cindodcindy.vieroshoesnew.R
import com.cindodcindy.vieroshoesnew.basedata.BaseActivity
import com.cindodcindy.vieroshoesnew.utils.validateEdittextEmpty
import com.cindodcindy.vieroshoesnew.view.MenuBaruActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    var auth: FirebaseAuth? = null
    var user: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initial()
    }

    private fun initial() {
        auth = FirebaseAuth.getInstance()
        user = FirebaseAuth.getInstance().currentUser

        btn_login.setOnClickListener {
            val getNama = edNamaLogin.text.toString()
            val getEmail = edEmailLogin.text.toString()
            val getPass = edPassLogin.text.toString()

            if (getEmail.validateEdittextEmpty() ||
                getPass.validateEdittextEmpty() ||
                getNama.validateEdittextEmpty()
            ) {
                showToast("Form masih kosong")
            } else {
                showDialog(true)
                auth!!.signInWithEmailAndPassword(getEmail, getPass)
                    .addOnCompleteListener { task: Task<AuthResult?> ->
                        if (task.isSuccessful) {
                            Hawk.put("namaProfile", getNama)
                            Hawk.put("emailProfile", getEmail)

                            showDialog(false)
                            val intent = Intent(this, MenuBaruActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            showDialog(false)
                            Toast.makeText(applicationContext, "Gagal Masuk", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
            }

        }

        tvForgotPass.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }

}