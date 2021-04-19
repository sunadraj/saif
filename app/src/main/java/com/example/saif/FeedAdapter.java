package com.example.saif;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder>  {


    private List<FeedModel> employs_list_filtered;
    private Context context;


    public FeedAdapter(Context context, List<FeedModel> employdata) {
        this.employs_list_filtered=employdata;
        this.context=context;
    }

    @NonNull
    @Override
    public FeedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new FeedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapter.ViewHolder viewHolder, int i) {
        FeedModel responModel =employs_list_filtered.get(i);



       /* viewHolder.status.setText("Nick Name :  "+responModel.getNickname());
        viewHolder.nickname.setText("Status :  "+responModel.getStatus());
        viewHolder.name.setText("Name : "+responModel.getName());
        viewHolder.birthday.setText("Birthday : "+responModel.getBirthday());
        viewHolder.portraid.setText("Portrayed : "+responModel.getPortrayed());
*/

        //  viewHolder.image.setImageResource(Integer.parseInt(responModel.getImg()));

        Picasso.with(context).load(employs_list_filtered.get(i).getDescription()).into(viewHolder.image);




    }

    @Override
    public int getItemCount() {
        return employs_list_filtered!=null?employs_list_filtered.size():0;
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView status,nickname,name,birthday,portraid;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

          /*  name=(TextView) itemView.findViewById(R.id.name);
            birthday=(TextView)itemView.findViewById(R.id.birthday);
            status=(TextView) itemView.findViewById(R.id.status);
            nickname=(TextView)itemView.findViewById(R.id.nickname);*/
            image=(ImageView) itemView.findViewById(R.id.image);
           // portraid=(TextView) itemView.findViewById(R.id.portraid);


        }
    }
}

