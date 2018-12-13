package com.gdglima.glabkotlin.gdglimaapp.ui.adapterskt

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.gdglima.glabkotlin.gdglimaapp.R
import com.gdglima.glabkotlin.gdglimaapp.model.EntityK
import kotlinx.android.synthetic.main.row_header_sponsor.view.*
import kotlinx.android.synthetic.main.row_sponsor.view.*

/**
 * Created by emedinaa on 3/09/17.
 */
class SponsorAdapterK(val activity:Activity,val sponsors:List<EntityK.SponsorK>, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mInflater:LayoutInflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    /**
     * Constantes
     * https://blog.egorand.me/where-do-i-put-my-constants-in-kotlin/
     */
    companion object {
        const val HEADER:Int = 1;
        const val ITEM:Int = 2;
        // public final int LARGE_TYPE=1;
        //public final int NORMAL_TYPE=2;
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTitle: TextView? = view.textViewTitle
    }

    class SponsorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTitle: TextView? = view.textViewName
        val imageView: ImageView? = view.imageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //val layoutInflater = LayoutInflater.from(parent.context)
        //return SpeakerAdapterK.ViewHolder(layoutInflater.inflate(R.layout.row_header_sponsor, parent, false))
        return buildViewHolder(parent,viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(sponsors[position]!=null){
            if(holder is HeaderViewHolder){
                holder.textViewTitle?.text= sponsors[position].title
            }else if(holder is SponsorViewHolder){
                //(holder as? SponsorViewHolder).textViewTitle.text= sponsors[position].title
                holder.textViewTitle?.text= sponsors[position].title
                Glide.with(holder.imageView?.context)
                        .load(sponsors[position].image).into(holder.imageView);
            }
        }
    }

    override fun getItemCount(): Int {
        return sponsors.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (isHeader(position)) HEADER else ITEM
    }

    private fun buildViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var view: View

        if (viewType == HEADER) {
            view = mInflater?.inflate(R.layout.row_header_sponsor, parent, false)
            return HeaderViewHolder(view)
        } else {
            view = mInflater?.inflate(R.layout.row_sponsor, parent, false)
            return SponsorViewHolder(view)
        }
    }
    /**
     * https://discuss.kotlinlang.org/t/ternary-operator/2116
     * return response.body()?.string() ?: "fail"
     */
    private fun isHeader(position:Int):Boolean{
        val sponsor:EntityK.SponsorK= sponsors[position]
        if(sponsor.type.equals(EntityK.ItemType.HEADER)) return true
        return false
    }
}