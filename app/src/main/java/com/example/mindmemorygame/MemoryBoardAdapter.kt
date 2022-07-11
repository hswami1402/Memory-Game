package com.example.mindmemorygame

import android.content.Context
import android.nfc.Tag
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindmemorygame.models.BoardSize
import kotlin.math.log
import kotlin.math.min

class MemoryBoardAdapter(
    private val context: Context,
    private val boardSize: BoardSize,
    private val cardImages : List<Int>
) : RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {

    companion object{
        private const val Margin_size = 10
        private const val TAG = "MemoryBoardAdapter"
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardWidth = parent.width / boardSize.getWidth() - (2* Margin_size)
        val cardHeight = parent.height / boardSize.getHeight() - (2* Margin_size)
        val cardSideLength = min(cardWidth , cardHeight)

        val view =  LayoutInflater.from(context).inflate(R.layout.memory_card, parent, false)
        val layoutParams = view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.setMargins(Margin_size, Margin_size, Margin_size, Margin_size)
        layoutParams.width = cardSideLength
        layoutParams.height = cardSideLength
        return ViewHolder( view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = boardSize.numCards

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)

        fun bind(position: Int) {
            //NO-OP
            imageButton.setImageResource(cardImages[position])
            imageButton.setOnClickListener{
                Log.i(TAG,"Clicked on position $position"  )
            }

        }
    }

}
