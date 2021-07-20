package com.cindodcindy.vieroshoesnew.view.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cindodcindy.vieroshoesnew.R
import com.cindodcindy.vieroshoesnew.basedata.BaseActivity
import com.cindodcindy.vieroshoesnew.model.DataProduk
import com.cindodcindy.vieroshoesnew.onclick.OnClickItemProduk
import com.cindodcindy.vieroshoesnew.view.adapter.AdapterDataProduk
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_product.*
import java.net.URLEncoder


class ProductActivity : BaseActivity() {
    var firebaseFirestore: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        initial()
    }

    private fun initial() {
        firebaseFirestore = FirebaseFirestore.getInstance()
        initGetDataProduk()

    }

    private fun initGetDataProduk() {
        showDialog(true)
        firebaseFirestore?.collection("data_produk")
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

    private fun initAdapter(mutableListDataProduk: MutableList<DataProduk>) {
        val adapterDataProduk = AdapterDataProduk(dataProdukList = mutableListDataProduk,
            object : OnClickItemProduk {
                override fun clickItem(any: Any, pos: Int) {
                    val dataProduks = mutableListDataProduk[pos]
                    val intent = Intent(this@ProductActivity, CheckoutActivity::class.java)
                        .putExtra("dataproduk", dataProduks)
                    startActivity(intent)
                }

                override fun clickChatWa(any: Any, pos: Int) {
                    val dataProduks = mutableListDataProduk[pos]
                    openWhatsApp(
                        dataProduks.phone.toString(),
                        "Yuk chat admin dengan produk ${dataProduks.title}"
                    )
                }
            })

        rvDataProduk.apply {
            adapter = adapterDataProduk
            layoutManager = LinearLayoutManager(this@ProductActivity)
            hasFixedSize()
        }
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