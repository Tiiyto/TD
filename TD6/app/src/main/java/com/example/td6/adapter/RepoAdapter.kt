package com.example.td6.adapter
import com.example.td6.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.td6.models.Repo

class RepoAdapter (val repos: ArrayList<Repo>, var context: Context): RecyclerView.Adapter<RepoAdapter.ViewHolder>()
{
    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val idTextView: TextView = view.findViewById(R.id.id)
        val nameTextView: TextView = view.findViewById(R.id.name)
        val fullnameTextView: TextView = view.findViewById(R.id.fullname)
        val URLTextView: TextView = view.findViewById(R.id.htmlurl)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var repoview: View = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent,false)
        return ViewHolder(repoview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.idTextView.text = repos[position].id.toString()
        holder.nameTextView.text = repos[position].name
        holder.fullnameTextView.text = repos[position].fullName
        holder.URLTextView.text = repos[position].html_url

    }

    override fun getItemCount(): Int {
        return repos.size
    }
}