package omninos.com.xlinx.Fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionLayout;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList;

import java.util.ArrayList;
import java.util.List;

import omninos.com.xlinx.Activities.AddPostActivity;
import omninos.com.xlinx.Adapters.PostAdapter;
import omninos.com.xlinx.Adapters.StoryAdapter;
import omninos.com.xlinx.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends Fragment implements View.OnClickListener {
    private RecyclerView storyCycle, postCycle;
    private FloatingActionMenu materialDesignFAM;
    private FloatingActionButton floatingActionButtonPost, floatingActionButtonStory, floatingActionButtonDP;

    public TimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);

        intIds(view);
        performActions();
        setAdapter();

        return view;
    }

    private void intIds(View view) {
        storyCycle = view.findViewById(R.id.storyCycle);
        postCycle = view.findViewById(R.id.postCycle);
        materialDesignFAM = view.findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButtonPost = view.findViewById(R.id.material_design_floating_action_menu_post);
        floatingActionButtonStory = view.findViewById(R.id.material_design_floating_action_menu_story);
        floatingActionButtonDP = view.findViewById(R.id.material_design_floating_action_menu_dp);
    }

    private void performActions() {
        floatingActionButtonPost.setOnClickListener(this);
        floatingActionButtonStory.setOnClickListener(this);
        floatingActionButtonDP.setOnClickListener(this);

    }

    private void setAdapter() {
        StoryAdapter storyAdapter = new StoryAdapter(getContext());
        storyCycle.setAdapter(storyAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        storyCycle.setLayoutManager(linearLayoutManager);

        PostAdapter postAdapter = new PostAdapter(getContext());
        postCycle.setAdapter(postAdapter);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        postCycle.setLayoutManager(linearLayoutManager1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.material_design_floating_action_menu_post:
                startActivity(new Intent(getActivity(), AddPostActivity.class));
                break;

            case R.id.material_design_floating_action_menu_story:

                break;

            case R.id.material_design_floating_action_menu_dp:

                break;
        }
    }
}
