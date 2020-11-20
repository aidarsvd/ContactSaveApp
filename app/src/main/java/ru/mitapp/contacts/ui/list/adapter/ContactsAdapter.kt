package ru.mitapp.contacts.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_item.view.*
import kotlinx.android.synthetic.main.fragment_info_add.view.*
import kotlinx.android.synthetic.main.fragment_info_add.view.name
import ru.mitapp.contacts.R
import ru.mitapp.contacts.service.db.User

class ContactsAdapter: RecyclerView.Adapter<ContactsAdapter.MyViewHolder>(){

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.nameAdapter.text = currentItem.name
        holder.itemView.phoneAdapter.text = currentItem.phoneNumber
        holder.itemView.emailAdapter.text = currentItem.email
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }


}