package id.refactory.app.refactoryapps.adapter;

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
//import id.refactory.app.refactoryapps.fragments.SOFFragment;

/**
 * Created by prana on 16/10/17.
 */

public class SOFAdapter extends RecyclerView.Adapter<SOFAdapter.ViewHolder> {

    public Context konteks; // -> context, bisa di ganti inisialisasinya eq: konteks
    public ArrayList<Datum> rappModAL; // -> rappModArrayList, bisa di ganti inisialisasinya eq: rappModAL

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_status,tv_assignment, tv_link ;
        private Button bt_report;

        public ViewHolder(View itemView) {

            super(itemView);
            tv_status = (TextView)itemView.findViewById(R.id.status);
            tv_assignment = (TextView)itemView.findViewById(R.id.assignment);
            tv_link = (TextView)itemView.findViewById(R.id.link);
            bt_report = (Button)itemView.findViewById(R.id.bt_report);
        }
    }

    // /membuat konstruktor HRAdapter
    public SOFAdapter(Context konteks, ArrayList<Datum> rappModAL) {
        this.konteks = konteks;
        this.rappModAL = rappModAL;
    }

    // ketika membuat public class HRAdapter extends RecyclerView.Adapter<HRAdapter.ViewHolder>
    // maka automatis dengan alt+enter  mengenerate : ViewHolder onCreateViewHolder(), onBindViewHolder() dan getItemCount()


    public SOFAdapter.ViewHolder onCreateViewHolder(ViewGroup v, int i) {
        View view = LayoutInflater.from(v.getContext()).inflate(R.layout.assignment_listview, v, false);
        return new SOFAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SOFAdapter.ViewHolder v3, int i) {
        if(rappModAL.get(i).getAssignmentType().equals("Stackoverflow")) {
            v3.tv_status.setText(rappModAL.get(i).getStatus());
            v3.tv_assignment.setText(rappModAL.get(i).getAssignmentType() + " :");
            v3.tv_link.setText("" + rappModAL.get(i).getUrl());
        }
    }

    @Override
    public int getItemCount() {
        return rappModAL.size();
    }
}
