package omninos.com.xlinx.Fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import omninos.com.xlinx.Activities.ChatActivity;
import omninos.com.xlinx.Activities.HomeActivity;
import omninos.com.xlinx.Adapters.MessagesAdapter;
import omninos.com.xlinx.Adapters.StoryAdapter;
import omninos.com.xlinx.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment implements View.OnClickListener {
    private RecyclerView messagesCycle;
    private View view;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_message, container, false);

        intIds(view);
        performActions();
        setAdapter();

        return view;
    }

    private void intIds(View view) {
        messagesCycle = view.findViewById(R.id.messagesCycle);
    }

    private void performActions() {
    }

    private void setAdapter() {
        MessagesAdapter messagesAdapter = new MessagesAdapter(getContext(), new MessagesAdapter.OpenChat() {
            @Override
            public void Open(int position) {
                startActivity(new Intent(getContext(), ChatActivity.class));
            }
        });
        messagesCycle.setAdapter(messagesAdapter);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        messagesCycle.setLayoutManager(linearLayoutManager1);

    }

    @Override
    public void onClick(View v) {

        }
}
