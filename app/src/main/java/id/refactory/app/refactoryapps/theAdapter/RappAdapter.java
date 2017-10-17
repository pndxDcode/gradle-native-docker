package id.refactory.app.refactoryapps.theAdapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import id.refactory.app.refactoryapps.R;
import id.refactory.app.refactoryapps.api.models.Datum;
import id.refactory.app.refactoryapps.api.models.RappMod;

/**
 * Created by prana on 06/10/17.
 */

public class RappAdapter extends RecyclerView.Adapter<RappAdapter.ViewHolder> {

    public Context context;
    public ArrayList<Datum> rappModArrayList;


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_status,tv_assignment, tv_link;
        private Button bt_report;

        public ViewHolder(View view) {
            super(view);
            tv_status = (TextView)view.findViewById(R.id.status);
            tv_assignment = (TextView)view.findViewById(R.id.assignment);
            tv_link = (TextView)view.findViewById(R.id.link);
            bt_report = (Button) view.findViewById(R.id.bt_report);
        }
    }


    public RappAdapter(Context context, ArrayList<Datum> rappModArrayList) {
        this.context = context;
        this.rappModArrayList = rappModArrayList;
    }

    //Ref : http://www.glamvian.com/Lebih-dalam-tentang-RecyclerView/
    //onCreateViewHolder yang dipanggil ketika RecyclerView menginstanisasi intance ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.assignment_listview, viewGroup, false);
        return new ViewHolder(view);
    }

    //onBindViewHolder method ini dipanggil ketika RecyclerView ingin mengisi view dengan data
    @Override
    public void onBindViewHolder(ViewHolder viewHolder4, int i) {
       viewHolder4.tv_status.setText(rappModArrayList.get(12).getStatus());
        viewHolder4.tv_assignment.setText(rappModArrayList.get(12).getAssignmentType()+" :");
       viewHolder4.tv_link.setText(""+ rappModArrayList.get(12).getUrl());

        // viewHolder.tv_status.setText(rappModArrayList.get(0).getStatus());
      //  viewHolder.tv_link.setText(rappModArrayList.get(0).getUrl())
    }


// Contoh code seblumnya
//    public void onBindViewHolder3(ViewHolder viewHolder, int i) {
//        viewHolder.tv_status.setText(rappModArrayList.get(i).getStatus());
//        viewHolder.tv_link.setText(""+ rappModArrayList.get(i).getTitle());
//    }



    //getItemCount yang return jumlah dari item ke dalam data source
    @Override
    public int getItemCount() {
        return rappModArrayList.size();
    }
}
