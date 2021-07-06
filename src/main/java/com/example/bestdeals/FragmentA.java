package com.example.bestdeals;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.ArrayList;


public class FragmentA extends Fragment {
    private RecyclerView recyclerView;
    private OfferAdapter offerAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private onFragmentInteractionListener fragmentListener;

    //Creates interface to pass variables to main
    public interface onFragmentInteractionListener{
        public void passData(int pic, String deals, String  name, String  details,
                             String per, String  price, String  discPrice, String loc);
    }


    public FragmentA() {
        // Required empty public constructor
    }

    public static FragmentA newInstance() {
        FragmentA fragment = new FragmentA();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        ArrayList<OfferItem> offerList = new ArrayList<>();
        //Creating Offer List items
        offerList.add(new OfferItem(R.drawable.icon_mcd, R.drawable.mcd, "McDonald's", "Any McDonald's outlet",
                "Applicable to any lunch meal set" ,"Buy 1 get 1 free", "1 Aug - 31 Aug",
                "32.00", "16.00"));
        offerList.add(new OfferItem(R.drawable.icon_nandos, R.drawable.nandos, "Nando's", "Any Nando's Outlet",
                "2 quarter chick, 2 side dishes, 2 ice lemon tea", "30% discount",
                "1 Sept - 5 Sept","60.00", "42.00"));
        offerList.add(new OfferItem(R.drawable.icon_llao, R.drawable.llao, "Llao Llao", "Any Llao Llao Outlet" ,
                "10% discount for large with free toppings","10% discount, free toppings",
                "25 Aug", "18.90", "17.00"));
        offerList.add(new OfferItem(R.drawable.icon_starbuck, R.drawable.starbuck, "Starbucks", "Any Starbucks outlet",
                "For any purchase of Frappucino beverages", "One for one", "September",
                "32.00", "16.00"));
        offerList.add(new OfferItem(R.drawable.icon_kenny_rogers, R.drawable.kenny_rogers, "Kenny Rogers Roaster",
                "Only at the Spring, Kuching", "Set meal includes roasted chicken, spaghetti, salad",
                "Two for the price of one", "1 Oct - 6 Oct", "30.00", "15.00"));
        offerList.add(new OfferItem(R.drawable.icon_subway, R.drawable.subway2, "Subway", "Any Subway Outlet",
                "Set meal includes roasted chicken, spaghetti, salad", "15% discount",
                "15 Apr - 15 May", " ", " "));

        //Setting recylcer view
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        offerAdapter = new OfferAdapter(offerList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(offerAdapter);
        offerAdapter.setOnItemClickListener(new OfferAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int position) {
                //Getting details of the itme
                OfferItem offerItem = offerList.get(position);
                int pic = offerItem.getRestPic();
                String deals = offerItem.getDeals();
                String name = offerItem.getName();
                String details = offerItem.getDetails();
                String per = offerItem.getPeriod();
                String price = offerItem.getPrice();
                String discPrice = offerItem.getDiscPrice();
                String loc = offerItem.getLocation();

                //Setting data to be passed to Main
                fragmentListener.passData(pic, deals, name, details, per, price, discPrice, loc);
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            fragmentListener = (onFragmentInteractionListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "Must implement onFragmentInteractionListener");
        }
    }
}