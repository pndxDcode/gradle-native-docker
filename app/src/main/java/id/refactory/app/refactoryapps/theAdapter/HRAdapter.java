package id.refactory.app.refactoryapps.theAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import id.refactory.app.refactoryapps.R;
import id.refactory.app.refactoryapps.api.models.Datum;

/**
 * Created by prana on 16/10/17.
 */

public class HRAdapter extends RecyclerView.Adapter<HRAdapter.ViewHolder> {

    public Context konteks; // -> context, bisa di ganti inisialisasinya eq: konteks
    public ArrayList<Datum> rappModAL; // -> rappModArrayList, bisa di ganti inisialisasinya eq: rappModAL

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_status,tv_assignment, tv_link ;
        private Button bt_report;

        //Konsturktor ini akan di automastis digenerate dengan alt+enter setelah membuat : public class ViewHolder extends RecyclerView.ViewHolder
        public ViewHolder(View Itemview) {
            super(Itemview);
            tv_status = (TextView)Itemview.findViewById(R.id.status);
            tv_assignment = (TextView)Itemview.findViewById(R.id.assignment);
            tv_link = (TextView)Itemview.findViewById(R.id.link);
            bt_report = (Button)Itemview.findViewById(R.id.bt_report);
        }
    }

    //membuat konstruktor HRAdapter
    public HRAdapter (Context konteks, ArrayList<Datum> rappModAL) {
        this.konteks = konteks;
        this.rappModAL = rappModAL;
    }


    // ketika membuat public class HRAdapter extends RecyclerView.Adapter<HRAdapter.ViewHolder>
    // maka automatis dengan alt+enter  mengenerate : ViewHolder onCreateViewHolder(), onBindViewHolder() dan getItemCount()

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup v, int i) {
        View view = LayoutInflater.from(v.getContext()).inflate(R.layout.assignment_listview, v, false);
        return new HRAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder v2, int position) {
        v2.tv_status.setText(rappModAL.get(2).getStatus());
        v2.tv_assignment.setText(rappModAL.get(2).getAssignmentType() + " :");
        v2.tv_link.setText(""+ rappModAL.get(2).getUrl());
    }

    @Override
    public int getItemCount() {
        return rappModAL.size();
    }



}
