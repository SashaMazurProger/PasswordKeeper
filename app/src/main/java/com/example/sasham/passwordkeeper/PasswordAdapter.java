package com.example.sasham.passwordkeeper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sasham.passwordkeeper.model.Password;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sasha M on 15.03.2018.
 */

public class PasswordAdapter extends RecyclerView.Adapter<PasswordAdapter.ViewHolder>{

    private List<Password> mPasswords;

    public PasswordAdapter(List<Password> passwords) {
        mPasswords = passwords;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.password_list_item,parent,false);

        ViewHolder viewHolder=new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Password password=mPasswords.get(position);

        holder.title.setText(password.getTitle());
        holder.email.setText(password.getEmail());
        holder.date.setText(password.getDate().toString());
    }

    @Override
    public int getItemCount() {
        return mPasswords.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.password_item_title)
        protected TextView title;

        @BindView(R.id.password_item_email)
        protected TextView email;

        @BindView(R.id.password_item_date)
        protected TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
