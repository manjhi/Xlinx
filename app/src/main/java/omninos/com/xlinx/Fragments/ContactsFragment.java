package omninos.com.xlinx.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import omninos.com.xlinx.Adapters.BottomSheetAdapter;
import omninos.com.xlinx.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {
private RecyclerView ContactsCycle;

    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        ContactsCycle = view.findViewById(R.id.ContactsCycle);

        BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(getContext());
        ContactsCycle.setAdapter(bottomSheetAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        ContactsCycle.setLayoutManager(linearLayoutManager);

        return view;
    }
}
