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

public class WPMAdapter extends RecyclerView.Adapter<WPMAdapter.ViewHolder> {

    public Context konteks; // -> context, bisa di ganti inisialisasinya eq: konteks
    public ArrayList<Datum> rappModAL; // -> rappModArrayList, bisa di ganti inisialisasinya eq: rappModAL

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_status,tv_assignmnet, tv_link ;
        private Button bt_report;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_status = (TextView)itemView.findViewById(R.id.status);
            tv_assignmnet = (TextView)itemView.findViewById(R.id.assignment);
            tv_link = (TextView)itemView.findViewById(R.id.link);
            bt_report = (Button)itemView.findViewById(R.id.bt_report);
        }
    }


    // /membuat konstruktor HRAdapter
    public WPMAdapter(Context konteks, ArrayList<Datum> rappModAL) {
        this.konteks = konteks;
        this.rappModAL = rappModAL;
    }


    public WPMAdapter.ViewHolder onCreateViewHolder(ViewGroup v, int i) {
        View view = LayoutInflater.from(v.getContext()).inflate(R.layout.assignment_listview, v, false);
        return new WPMAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WPMAdapter.ViewHolder v0, int position) {
        v0.tv_status.setText(rappModAL.get(0).getStatus());
        v0.tv_assignmnet.setText(rappModAL.get(0).getAssignmentType()+" :");
        v0.tv_link.setText(""+ rappModAL.get(0).getUrl());
    }

    @Override
    public int getItemCount() {
        return rappModAL.size();
    }
}
