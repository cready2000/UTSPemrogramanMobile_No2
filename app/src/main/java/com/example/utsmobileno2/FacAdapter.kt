package com.example.utsmobileno2
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.utsmobileno2.FacData
import kotlinx.android.synthetic.main.list_fac.view.*
class FacAdapter(private val itemFac: List<FacData>, private val clickListener:
    (FacData) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // Fungsi CreateViewHolder Sesuai Array <FacData>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_fac, parent, false)
        return PartViewHolder(view)
    }
    // Fungsi BindViewHolder
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(itemFac[position], clickListener)
    }
    // Fungsi getItemCount
    override fun getItemCount() = itemFac.size
    // Convert to Component Attribute
    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: FacData, clickListener: (FacData) -> Unit) {
            itemView.tv_list_fac.text = data.nameFac
            itemView.image_fac.setImageResource(data.imgFac)
            itemView.image_fac.contentDescription = data.nameFac
            itemView.setOnClickListener { clickListener(data) }
        }
    }
}