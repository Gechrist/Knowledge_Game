package com.example.game;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.AbstractCollection;
import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    Context context;
    ArrayList<Player> players;

    public Adapter(Context context, ArrayList<Player> players) {
        this.context = context;
        this.players = players;
    }

    @Override
    public int getCount() {
        return this.players.size();
    }

    @Override
    public Object getItem(int i) {
        return players.get(i);
    }

    @Override
    public long getItemId(int i) {
        return players.indexOf(getItem(i));
    }

    @Override
    public View getView(int i, View newview, ViewGroup viewGroup) {
        if(newview == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            newview = inflater.inflate(R.layout.list, null);
        }

        TextView txtview_t10score = (TextView) newview.findViewById(R.id.txtview_score);
        TextView txtview_t10name = (TextView) newview.findViewById(R.id.txtview_name);
        TextView txtview_t10no = (TextView) newview.findViewById(R.id.txtView_no);


        txtview_t10no.setText(""+(i+1));
        txtview_t10name.setText(players.get(i).getName());
        txtview_t10score.setText(players.get(i).getScore()+"/10");

        return newview;

    }
}
