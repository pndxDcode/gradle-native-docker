package id.refactory.app.refactoryapps.Tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import id.refactory.app.refactoryapps.R;
import id.refactory.app.refactoryapps.fragments.HRFragment;
import id.refactory.app.refactoryapps.fragments.HomeFragment;
import id.refactory.app.refactoryapps.fragments.SOFFragment;
import id.refactory.app.refactoryapps.fragments.WPMFragment;

/**
 * Created by prana on 04/10/17.
 */

public class MyAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private String[] titles = {"Project", "WPM", "HackerRank", "StackOverFlow", "OpenSource"};
    int[] icon = new int[]{R.drawable.ic_projects, R.drawable.ic_wpm, R.drawable.ic_hr, R.drawable.ic_sof, R.drawable.ic_os};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c) {
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon = (int) (24 * scale + 0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        if (position == 0) {
            frag = new HomeFragment();
        } else if (position == 1) {
            frag = new WPMFragment();
        } else if (position == 2) {
            frag = new HRFragment();
        } else if (position == 3) {
            frag = new SOFFragment();
        } else if (position == 4) {
            frag = new SOFFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position) {
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0, 0, heightIcon, heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is, 0, sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }

}
