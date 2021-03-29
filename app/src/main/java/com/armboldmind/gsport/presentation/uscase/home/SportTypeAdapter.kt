package com.armboldmind.gsport.presentation.uscase.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.armboldmind.gsport.R
import com.armboldmind.gsport.data.dto.Sport
import com.armboldmind.gsport.databinding.ListItemSportTypeBinding
import com.armboldmind.gsport.presentation.helpers.asyncLoadImage
import com.armboldmind.gsport.presentation.helpers.toHumanReadableDate

class SportTypeAdapter(
    private val callback: (article: Sport, position: Int) -> Unit
) : RecyclerView.Adapter<SportTypeAdapter.ArticleViewHolder>() {

    private val dataSource = mutableListOf<Sport>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        val binding = ListItemSportTypeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val sport = dataSource[position]
        holder.binding.sportType.text = sport.type
        holder.binding.date.text = sport.date.toHumanReadableDate()
        holder.binding.sportImage.asyncLoadImage(sport.image,
            holder.binding.sportImage.resources.getDimensionPixelOffset(R.dimen.card_image_rounding_radius))
        holder.binding.root.setOnClickListener {
            callback(sport, position)
        }
    }

    override fun getItemCount(): Int =
        dataSource.size

    fun addNews(dataSource: List<Sport>) {
        this.dataSource.clear()
        this.dataSource.addAll(dataSource)
        notifyDataSetChanged()
    }

    class ArticleViewHolder(val binding: ListItemSportTypeBinding): RecyclerView.ViewHolder(binding.root)

}