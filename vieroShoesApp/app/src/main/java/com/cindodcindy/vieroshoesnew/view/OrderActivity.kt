package com.cindodcindy.vieroshoesnew.view

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cindodcindy.vieroshoesnew.R
import com.cindodcindy.vieroshoesnew.basedata.BaseActivity
import com.cindodcindy.vieroshoesnew.model.DataProduk
import com.cindodcindy.vieroshoesnew.onclick.OnClickItemMyProduk
import com.cindodcindy.vieroshoesnew.view.adapter.AdapterDataMyProduk
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_order.*
import java.net.URLEncoder

class OrderActivity : BaseActivity() {
    var firebaseFirestore: FirebaseFirestore? = null
    var firebaseUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        initial()
    }

    private fun initial() {
        firebaseUser = FirebaseAuth.getInstance().currentUser
        firebaseFirestore = FirebaseFirestore.getInstance()
        initGetDataMyOrder()
    }

    private fun initGetDataMyOrder() {
        showDialog(true)
        firebaseFirestore?.collection("data_produk")
            ?.whereEqualTo("uidUser", firebaseUser?.uid)
            ?.get()
            ?.addOnCompleteListener {
                val mutableList: MutableList<DataProduk> = mutableListOf()
                showDialog(false)
                for (documentin in it.result!!) {
                    val dataProduk = documentin.toObject(DataProduk::class.java)
                    mutableList.add(dataProduk)
                    initAdapter(mutableList)
                }
            }?.addOnFailureListener {
                showDialog(false)
            }
    }

    private fun initAdapter(mutableList: MutableList<DataProduk>) {
        val adapterDataMyProduk = AdapterDataMyProduk(mutableList, object : OnClickItemMyProduk {
            override fun clickItemMaps(any: Any, pos: Int) {
                val dataMyProduk = any as DataProduk
                navigateToMaps(dataMyProduk)
            }

            override fun clickChatWa(any: Any, pos: Int) {
                val dataMyProduk = any as DataProduk
                openWhatsApp(
                    dataMyProduk.phone.toString(),
                    "Yuk chat admin dengan produk ${dataMyProduk.title}"
                )
            }
        })


        rvMyOrder.apply {
            adapter = adapterDataMyProduk
            layoutManager = LinearLayoutManager(this@OrderActivity)
            hasFixedSize()
        }
    }

    fun navigateToMaps(dataProduk: DataProduk) {
        val gmmIntentUri =
            Uri.parse("google.navigation:q=" + dataProduk.latitude + "," + dataProduk.longitude + "")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }


    private fun openWhatsApp(numero: String, mensaje: String) {
        try {
            val packageManager: PackageManager = packageManager
            val i = Intent(Intent.ACTION_VIEW)
            val url =
                "https://api.whatsapp.com/send?phone=$numero&text=" + URLEncoder.encode(
                    mensaje,
                    "UTF-8"
                )
            i.setPackage("com.whatsapp")
            i.data = Uri.parse(url)
            if (i.resolveActivity(packageManager) != null) {
                startActivity(i)
            } else {
                showToast("Tidak ada aplikasi whatsapp")
            }
        } catch (e: Exception) {
            showToast("Tidak ada aplikasi whatsapp")
        }
    }
}