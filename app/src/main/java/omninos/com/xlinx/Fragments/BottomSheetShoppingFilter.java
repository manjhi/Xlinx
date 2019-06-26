package omninos.com.xlinx.Fragments;


import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import omninos.com.xlinx.Adapters.FilterAdapter;
import omninos.com.xlinx.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomSheetShoppingFilter extends BottomSheetDialogFragment implements View.OnClickListener {
    private RecyclerView filterrv;
    private Button pricebtn, brandbtn, discountbtn, colorbtn, sizebtn;
    private ImageView cancel;

    public BottomSheetShoppingFilter() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_sheet_shopping_filter, container, false);

        intIds(view);
        setAdapter();

        return view;
    }

    private void intIds(View view) {
        filterrv = view.findViewById(R.id.filterrv);
        pricebtn = view.findViewById(R.id.pricebtn);
        brandbtn = view.findViewById(R.id.brandbtn);
        discountbtn = view.findViewById(R.id.discountbtn);
        colorbtn = view.findViewById(R.id.colorbtn);
        sizebtn = view.findViewById(R.id.sizebtn);
        cancel = view.findViewById(R.id.cancel);

        pricebtn.setOnClickListener(this);
        brandbtn.setOnClickListener(this);
        discountbtn.setOnClickListener(this);
        colorbtn.setOnClickListener(this);
        sizebtn.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    private void setAdapter(){
        FilterAdapter filterAdapter=new FilterAdapter(getContext());
        filterrv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        filterrv.setAdapter(filterAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pricebtn:
                pricebtn.setBackgroundResource(R.drawable.btn_white);
                discountbtn.setBackgroundResource(R.drawable.btn_back_grey);
                sizebtn.setBackgroundResource(R.drawable.btn_back_grey);
                colorbtn.setBackgroundResource(R.drawable.btn_back_grey);
                brandbtn.setBackgroundResource(R.drawable.btn_back_grey);
                break;
            case R.id.brandbtn:
                brandbtn.setBackgroundResource(R.drawable.btn_white);
                discountbtn.setBackgroundResource(R.drawable.btn_back_grey);
                sizebtn.setBackgroundResource(R.drawable.btn_back_grey);
                colorbtn.setBackgroundResource(R.drawable.btn_back_grey);
                pricebtn.setBackgroundResource(R.drawable.btn_back_grey);
                break;
            case R.id.discountbtn:
                brandbtn.setBackgroundResource(R.drawable.btn_back_grey);
                discountbtn.setBackgroundResource(R.drawable.btn_white);
                sizebtn.setBackgroundResource(R.drawable.btn_back_grey);
                colorbtn.setBackgroundResource(R.drawable.btn_back_grey);
                pricebtn.setBackgroundResource(R.drawable.btn_back_grey);
                break;
            case R.id.colorbtn:
                brandbtn.setBackgroundResource(R.drawable.btn_back_grey);
                discountbtn.setBackgroundResource(R.drawable.btn_back_grey);
                sizebtn.setBackgroundResource(R.drawable.btn_back_grey);
                colorbtn.setBackgroundResource(R.drawable.btn_white);
                pricebtn.setBackgroundResource(R.drawable.btn_back_grey);
                break;
            case R.id.sizebtn:
                brandbtn.setBackgroundResource(R.drawable.btn_back_grey);
                discountbtn.setBackgroundResource(R.drawable.btn_back_grey);
                sizebtn.setBackgroundResource(R.drawable.btn_white);
                colorbtn.setBackgroundResource(R.drawable.btn_back_grey);
                pricebtn.setBackgroundResource(R.drawable.btn_back_grey);
                break;

            case R.id.cancel:
                dismiss();
                break;
        }
    }
}
