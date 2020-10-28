package com.example.td5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ContactsAdapter(val contacts: ArrayList<Contact>, var context: Context) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var contactview: View = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(contactview)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.firstnameTextView.text = contacts[position].prenom
        holder.lastnameTextView.text = contacts[position].nom
        Glide.with(context)
            .load(contacts[position].imageUrl)
            .into(holder.imageV)
    }
    override fun getItemCount(): Int {
        return contacts.size
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val firstnameTextView: TextView = view.findViewById(R.id.contact_firstname)
        val lastnameTextView: TextView = view.findViewById(R.id.contact_lastname)
        val imageV: ImageView = view.findViewById(R.id.imgContact)
    }
}