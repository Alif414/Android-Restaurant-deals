package com.example.bestdeals;

import android.graphics.Paint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentB#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class FragmentB extends Fragment {

    ImageView pic;
    TextView deals;
    TextView name;
    TextView details;
    TextView period;
    TextView price;
    TextView discPrice;
    TextView loc;


    private static final String ARG_PARAM1 = "pic";
    private static final String ARG_PARAM2 = "deals";
    private static final String ARG_PARAM3 = "name";
    private static final String ARG_PARAM4 = "details";
    private static final String ARG_PARAM5 = "per";
    private static final String ARG_PARAM6 = "price";
    private static final String ARG_PARAM7 = "discPrice";
    private static final String ARG_PARAM8 = "loc";

    private int mParamPic;
    private String mParamDeals, mParamName, mParamDetails, mParamPer, mParamPrice, mParamDiscPrice, mParamLoc;

    public static FragmentB newInstance(int pic, String deals, String  name, String  details,
                                        String per, String  price, String  discPrice, String loc) {
        FragmentB fragment = new FragmentB();
        Bundle args = new Bundle();
        //Setting data
        args.putInt(ARG_PARAM1, pic);
        args.putString(ARG_PARAM2, deals);
        args.putString(ARG_PARAM3, name);
        args.putString(ARG_PARAM4, details);
        args.putString(ARG_PARAM5, per);
        args.putString(ARG_PARAM6, price);
        args.putString(ARG_PARAM7, discPrice);
        args.putString(ARG_PARAM8, loc);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentB() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            //Getting data from Main
            mParamPic = getArguments().getInt(ARG_PARAM1);
            mParamDeals = getArguments().getString(ARG_PARAM2);
            mParamName = getArguments().getString(ARG_PARAM3);
            mParamDetails = getArguments().getString(ARG_PARAM4);
            mParamPer = getArguments().getString(ARG_PARAM5);
            mParamPrice = getArguments().getString(ARG_PARAM6);
            mParamDiscPrice = getArguments().getString(ARG_PARAM7);
            mParamLoc = getArguments().getString(ARG_PARAM8);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        pic = v.findViewById(R.id.pic2);
        deals = v.findViewById(R.id.deals2);
        name = v.findViewById(R.id.name2);
        details = v.findViewById(R.id.details2);
        period = v.findViewById(R.id.period2);
        price = v.findViewById(R.id.prevPrice);
        discPrice = v.findViewById(R.id.discPrice);
        loc = v.findViewById(R.id.location);

        pic.setImageResource(mParamPic);
        deals.setText(mParamDeals);
        name.setText(mParamName);
        details.setText(mParamDetails);
        period.setText(mParamPer);
        price.setText(mParamPrice);
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        discPrice.setText(mParamDiscPrice);
        loc.setText(mParamLoc);

        return v;
    }
}