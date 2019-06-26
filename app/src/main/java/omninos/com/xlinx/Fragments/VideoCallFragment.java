package omninos.com.xlinx.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import omninos.com.xlinx.Adapters.VideoCallAdapter;
import omninos.com.xlinx.Adapters.VoiceCallAdapter;
import omninos.com.xlinx.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoCallFragment extends Fragment {
private RecyclerView recyclerView;

    public VideoCallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_video_call, container, false);

        intIds(view);
        setAdapter();

        return view;
    }

    private void intIds(View view){
        recyclerView = view.findViewById(R.id.videoCallCycle);
    }

    private void setAdapter(){
        VideoCallAdapter videoCallAdapter = new VideoCallAdapter(getContext());
        recyclerView.setAdapter(videoCallAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
