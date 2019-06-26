package omninos.com.xlinx.Fragments;


import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import omninos.com.xlinx.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomSheetSortFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private ImageView cancel, availability, duration, departureETL, departureLTE, ArrivalETL, ArrivalLTE;

    public BottomSheetSortFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_sheet_sort, container, false);

        intIds(view);
        performActions();

        return view;
    }

    private void intIds(View view) {
        cancel = view.findViewById(R.id.cancel);
        availability = view.findViewById(R.id.availability);
        duration = view.findViewById(R.id.duration);
        departureETL = view.findViewById(R.id.departureETL);
        departureLTE = view.findViewById(R.id.departureLTE);
        ArrivalETL = view.findViewById(R.id.ArrivalETL);
        ArrivalLTE = view.findViewById(R.id.ArrivalLTE);
    }

    private void performActions(){
        cancel.setOnClickListener(this);
        availability.setOnClickListener(this);
        duration.setOnClickListener(this);
        departureETL.setOnClickListener(this);
        departureLTE.setOnClickListener(this);
        ArrivalETL.setOnClickListener(this);
        ArrivalLTE.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:
                dismiss();
                break;

            case R.id.availability:
                availability.setImageResource(R.drawable.blue_circle);
                duration.setImageResource(R.drawable.grey_circle_outline);
                departureETL.setImageResource(R.drawable.grey_circle_outline);
                departureLTE.setImageResource(R.drawable.grey_circle_outline);
                ArrivalETL.setImageResource(R.drawable.grey_circle_outline);
                ArrivalLTE.setImageResource(R.drawable.grey_circle_outline);
                break;

            case R.id.duration:
                duration.setImageResource(R.drawable.blue_circle);
                availability.setImageResource(R.drawable.grey_circle_outline);
                departureETL.setImageResource(R.drawable.grey_circle_outline);
                departureLTE.setImageResource(R.drawable.grey_circle_outline);
                ArrivalETL.setImageResource(R.drawable.grey_circle_outline);
                ArrivalLTE.setImageResource(R.drawable.grey_circle_outline);
                break;

            case R.id.departureETL:
                departureETL.setImageResource(R.drawable.blue_circle);
                availability.setImageResource(R.drawable.grey_circle_outline);
                duration.setImageResource(R.drawable.grey_circle_outline);
                departureLTE.setImageResource(R.drawable.grey_circle_outline);
                ArrivalETL.setImageResource(R.drawable.grey_circle_outline);
                ArrivalLTE.setImageResource(R.drawable.grey_circle_outline);
                break;

            case R.id.departureLTE:
                departureLTE.setImageResource(R.drawable.blue_circle);
                availability.setImageResource(R.drawable.grey_circle_outline);
                duration.setImageResource(R.drawable.grey_circle_outline);
                departureETL.setImageResource(R.drawable.grey_circle_outline);
                ArrivalETL.setImageResource(R.drawable.grey_circle_outline);
                ArrivalLTE.setImageResource(R.drawable.grey_circle_outline);
                break;

            case R.id.ArrivalETL:
                ArrivalETL.setImageResource(R.drawable.blue_circle);
                availability.setImageResource(R.drawable.grey_circle_outline);
                duration.setImageResource(R.drawable.grey_circle_outline);
                departureETL.setImageResource(R.drawable.grey_circle_outline);
                departureLTE.setImageResource(R.drawable.grey_circle_outline);
                ArrivalLTE.setImageResource(R.drawable.grey_circle_outline);
                break;

            case R.id.ArrivalLTE:
                ArrivalLTE.setImageResource(R.drawable.blue_circle);
                availability.setImageResource(R.drawable.grey_circle_outline);
                duration.setImageResource(R.drawable.grey_circle_outline);
                departureETL.setImageResource(R.drawable.grey_circle_outline);
                departureLTE.setImageResource(R.drawable.grey_circle_outline);
                ArrivalETL.setImageResource(R.drawable.grey_circle_outline);
                break;
        }
    }
}
