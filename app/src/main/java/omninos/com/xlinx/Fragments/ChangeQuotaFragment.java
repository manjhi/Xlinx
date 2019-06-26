package omninos.com.xlinx.Fragments;


import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import omninos.com.xlinx.Adapters.ChangequotaAdapter;
import omninos.com.xlinx.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangeQuotaFragment extends Fragment {
    private RecyclerView changequotarv;

    public ChangeQuotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_quota, container, false);

        intIds(view);
        setAdapter();

        return view;
    }

    private void intIds(View view){
        changequotarv=view.findViewById(R.id.changequotarv);
    }

    private void setAdapter(){
        ChangequotaAdapter adapter=new ChangequotaAdapter(getActivity());
        changequotarv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        changequotarv.setAdapter(adapter);
    }
}
