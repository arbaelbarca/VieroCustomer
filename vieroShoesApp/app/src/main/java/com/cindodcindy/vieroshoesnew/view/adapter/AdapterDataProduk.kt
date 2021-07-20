package com.cindodcindy.vieroshoesnew.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cindodcindy.vieroshoesnew.R
import com.cindodcindy.vieroshoesnew.model.DataProduk
import com.cindodcindy.vieroshoesnew.onclick.OnClickItemProduk
import com.cindodcindy.vieroshoesnew.utils.loadImageUrl
import kotlinx.android.synthetic.main.layout_item_dataproduk.view.*

class AdapterDataProduk(
    val dataProdukList: MutableList<DataProduk>,
    val onClickItemProduk: OnClickItemProduk
) :
    RecyclerView.Adapter<AdapterDataProduk.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_dataproduk, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataProduk = dataProdukList[position]
        holder.apply {
            itemView.apply {
                tvNamaProduk.text = "Nama Produk : " + dataProduk.title
                tvHargaProduk.text = "Harga : " + dataProduk.hargaProduk
                tvDescProduk.text = "Deskripsi : " + dataProduk.description

                imgDataProduk.loadImageUrl(dataProduk.image.toString(), context)

                btnBeliProduk.setOnClickListener {
                    onClickItemProduk.clickItem(dataProduk, position)
                }

                btnWaProduk.setOnClickListener {
                    onClickItemProduk.clickChatWa(dataProduk, position)
                }
            }
            itemView.setOnClickListener {
                onClickItemProduk.clickItem(dataProduk, position)
            }
        }

    }

    override fun getItemCount(): Int {
        return dataProdukList.size
    }
}