package com.cindodcindy.vieroshoesnew.view.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import com.cindodcindy.vieroshoesnew.R
import com.cindodcindy.vieroshoesnew.basedata.BaseActivity
import com.cindodcindy.vieroshoesnew.utils.validateEdittextEmpty
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : BaseActivity() {
    var auth: FirebaseAuth? = null
    var user: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        initial()
    }

    private fun initial() {
        auth = FirebaseAuth.getInstance()
        user = FirebaseAuth.getInstance().currentUser

        btnSendForgot.setOnClickListener {
            val getEmail = edEmailForgotPassword.text.toString()

            if (getEmail.validateEdittextEmpty()) {
                showToast("Form masiih ada yg kosong")
            } else {
                sendForgotPass(getEmail)
            }
        }
    }

    private fun sendForgotPass(email: String) {
        showDialog(true)
        auth?.sendPasswordResetEmail(email)
            ?.addOnCompleteListener {
                if (it.isSuccessful) {
                    showDialog(false)
                    alertDialog()
                }
            }
    }

    private fun alertDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setMessage("Silahkan cek email anda untuk memperbarui password")
        alertDialog.setPositiveButton("Ok", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                dialog?.dismiss()
            }
        })

        alertDialog.create().show()
    }
}