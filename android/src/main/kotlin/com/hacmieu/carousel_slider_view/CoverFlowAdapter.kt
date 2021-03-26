package com.hacmieu.carousel_slider_view

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterActivity
import java.util.*

class CoverFlowAdapter(private var activity: AppCompatActivity? = null, private var data: ArrayList<Game>? = null) : BaseAdapter() {

    override fun getCount(): Int {
        return data!!.size
    }

    override fun getItem(position: Int): Game {
        return data!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder: ViewHolder
        val retView: View

        if (convertView == null) {
            val inflater = activity!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            retView = inflater.inflate(R.layout.item_flow_view, null, false)
            viewHolder = ViewHolder(retView)
            retView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
            retView = convertView
        }

        viewHolder.gameImage.setImageResource(data!![position].getImageSource())
        viewHolder.gameName.text = data!![position].getName()

        retView!!.setOnClickListener(onClickListener(position))

        return retView!!
    }

    private fun onClickListener(position: Int): View.OnClickListener? {
        return View.OnClickListener {
            val dialog = Dialog(activity)
            dialog.setContentView(R.layout.dialog_game_info)
            dialog.setCancelable(true) // dimiss when touching outside
            dialog.setTitle("Game Details")
            val text = dialog.findViewById<View>(R.id.name) as TextView
            text.text = getItem(position).getName()
            val image = dialog.findViewById<View>(R.id.image) as ImageView
            image.setImageResource(getItem(position).getImageSource())
            dialog.show()
        }
    }

    private class ViewHolder(v: View) {
         val gameName: TextView = v.findViewById<View>(R.id.name) as TextView
         val gameImage: ImageView = v.findViewById<View>(R.id.image) as ImageView

    }

    fun CoverFlowAdapter(context: AppCompatActivity?, objects: ArrayList<Game>?) {
        activity = context
        data = objects
    }
}