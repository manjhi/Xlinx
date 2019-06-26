package omninos.com.xlinx.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import omninos.com.xlinx.Activities.ShoppingProductsDetails;
import omninos.com.xlinx.Adapters.WesterWearAdapter;
import omninos.com.xlinx.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WesternWearFragment extends Fragment {
    private RecyclerView WesternWearCycle;


    public WesternWearFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_western_wear, container, false);

        intIds(view);
        performActions();
        setAdapter();

        return view;
    }

    private void intIds(View view){
        WesternWearCycle = view.findViewById(R.id.WesternWearCycle);
    }

    private void performActions(){

    }

    private void setAdapter(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        WesternWearCycle.setLayoutManager(gridLayoutManager);
        WesterWearAdapter westerWearAdapter = new WesterWearAdapter(getContext(), new WesterWearAdapter.Details() {
            @Override
            public void Open(int position) {
                startActivity(new Intent(getContext(), ShoppingProductsDetails.class));
            }
        });
        WesternWearCycle.setAdapter(westerWearAdapter);

    }
}
