package omninos.com.xlinx.Fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import omninos.com.xlinx.Activities.BookSeatsActivity;
import omninos.com.xlinx.Adapters.ShowMallAdapter;
import omninos.com.xlinx.Adapters.ShowTimeAdapter;
import omninos.com.xlinx.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowTimeFragment extends Fragment implements View.OnClickListener {
    private RecyclerView showMallCycle;
    private Button time1, time2;

    public ShowTimeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_time, container, false);

        intIds(view);
        performActions();
        setAdapter();

        return view;
    }

    private void intIds(View view) {
        showMallCycle = view.findViewById(R.id.showMallCycle);
        time1 = view.findViewById(R.id.time1);
        time2 = view.findViewById(R.id.time2);
    }

    private void performActions() {
        time1.setOnClickListener(this);
        time2.setOnClickListener(this);
    }

    private void setAdapter() {
        ShowMallAdapter showMallAdapter = new ShowMallAdapter(getContext());
        showMallCycle.setAdapter(showMallAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        showMallCycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.time1:
                time1.setTextColor(Color.parseColor("#ffffff"));
                time1.setBackground(getResources().getDrawable(R.drawable.bg_btn_blue_round_corners));
                time2.setTextColor(Color.parseColor("#000000"));
                time2.setBackground(getResources().getDrawable(R.drawable.background_round_corners_blue_outline));
                startActivity(new Intent(getContext(), BookSeatsActivity.class));
                break;

            case R.id.time2:
                time2.setTextColor(Color.parseColor("#ffffff"));
                time2.setBackground(getResources().getDrawable(R.drawable.bg_btn_blue_round_corners));
                time1.setTextColor(Color.parseColor("#000000"));
                time1.setBackground(getResources().getDrawable(R.drawable.background_round_corners_blue_outline));
                break;
        }
    }
}
