package com.cindodcindy.vieroshoesnew.view.activity

import android.os.Bundle
import com.cindodcindy.vieroshoesnew.R
import com.cindodcindy.vieroshoesnew.basedata.BaseActivity
import com.cindodcindy.vieroshoesnew.model.DataProduk
import com.cindodcindy.vieroshoesnew.utils.loadImageUrl
import com.cindodcindy.vieroshoesnew.utils.validateEdittextEmpty
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_checkout.*
import java.text.SimpleDateFormat
import java.util.*

class CheckoutActivity : BaseActivity() {
    var dataProduk: DataProduk? = null
    var firebaseFirestore: FirebaseFirestore? = null
    var firebaseUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        initial()
    }

    private fun initial() {
        firebaseUser = FirebaseAuth.getInstance().currentUser
        firebaseFirestore = FirebaseFirestore.getInstance()
        dataProduk = intent.getSerializableExtra("dataproduk") as DataProduk?

        initData(dataProduk)
        initOnClick()
    }

    private fun initOnClick() {
        imgIncrese.setOnClickListener {
            val value = edValueQty.text.toString().toInt() + 1
            edValueQty.text = value.toString()
            val total = dataProduk?.hargaProduk?.toInt()!! * value
            tvTotalCheckout.text = "Total : $total"
            tvQtyCheckout.text = "Quantity : $value"
        }

        imgDecrese.setOnClickListener {
            val value = edValueQty.text.toString().toInt() - 1
            edValueQty.text = value.toString()
            val total = dataProduk?.hargaProduk?.toInt()!! * value
            tvTotalCheckout.text = "Total : $total"
            tvQtyCheckout.text = "Quantity : $value"
        }

        btnCheckout.setOnClickListener {
            val getNamaPemesan = edInputNamaPemesan.text.toString()
            val getBayar = edInputBayarCheckout.text.toString()

            if (getNamaPemesan.validateEdittextEmpty() ||
                getBayar.validateEdittextEmpty()
            ) {
                showToast("Form tidak boleh kosong")
            } else updateData(getNamaPemesan, getBayar)
        }
    }

    private fun updateData(getNamaPemesan: String, getBayar: String) {
        showDialog(true)
        val currentDate: String =
            SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(Date())

        val dataProduks = DataProduk()
        dataProduks.title = dataProduk?.title
        dataProduks.hargaProduk = dataProduk?.hargaProduk
        dataProduks.description = dataProduk?.description
        dataProduks.image = dataProduk?.image.toString()
        dataProduks.namaCustomer = getNamaPemesan
        dataProduks.inputCustomer = getBayar
        dataProduks.tanggalBayar = currentDate
        dataProduks.uuid = dataProduk?.uuid
        dataProduks.uidUser = firebaseUser?.uid
        dataProduks.quantityProduk = tvQtyCheckout.text.toString()
        dataProduks.total = tvTotalCheckout.text.toString()
        dataProduks.phone = dataProduk?.phone
        dataProduks.latitude = dataProduk?.latitude
        dataProduks.longitude = dataProduk?.longitude

        firebaseFirestore?.collection("data_produk")
            ?.document(dataProduk?.uuid.toString())
            ?.set(dataProduks)
            ?.addOnSuccessListener {
                showDialog(false)
                showToast("Berhasil Order")
                finish()
            }?.addOnFailureListener {
                showToast("Order Error ${it.message}")
                showDialog(false)
            }
    }

    private fun initData(dataProduk: DataProduk?) {
        imgDataProdukCheckout.loadImageUrl(dataProduk?.image.toString(), this)
        tvNamaProdukCheckout.text = dataProduk?.title
        tvHargaProdukCheckout.text = dataProduk?.hargaProduk
        tvDescProdukCheckout.text = dataProduk?.description

        tvTotalCheckout.text = dataProduk?.hargaProduk
        tvQtyCheckout.text = edValueQty.text.toString()
    }
}