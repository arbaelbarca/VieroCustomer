package com.cindodcindy.vieroshoesnew.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cindodcindy.vieroshoesnew.R
import com.cindodcindy.vieroshoesnew.model.DataProduk
import com.cindodcindy.vieroshoesnew.onclick.OnClickItemMyProduk
import com.cindodcindy.vieroshoesnew.utils.loadImageUrl
import kotlinx.android.synthetic.main.order_list.view.*

class AdapterDataMyProduk(
    val dataProdukList: MutableList<DataProduk>,
    val onClickItemProduk: OnClickItemMyProduk
) :
    RecyclerView.Adapter<AdapterDataMyProduk.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataProduk = dataProdukList[position]
        holder.apply {
            itemView.apply {
                tvNamaProdukOrder.text = "Nama Produk : " + dataProduk.title
                tvHargaProdukOrder.text = "Harga : " + dataProduk.hargaProduk
                tvDescProdukOrder.text = "Deskripsi : " + dataProduk.description

                tvTglBayarOrder.text = dataProduk.tanggalBayar
                tvJumlahOrder.text = dataProduk.quantityProduk
                tvTotalOrder.text = dataProduk.total

                imgProdukOrder.loadImageUrl(dataProduk.image.toString(), context)

                imgMapsAdmin.setOnClickListener {
                    onClickItemProduk.clickItemMaps(dataProduk, position)
                }

                imgChatWaAdmin.setOnClickListener {
                    onClickItemProduk.clickChatWa(dataProduk, position)
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return dataProdukList.size
    }
}