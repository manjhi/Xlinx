package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupMenu;

import omninos.com.xlinx.Adapters.MediaAdapter;
import omninos.com.xlinx.R;

public class ViewContactActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView back, options;
    private RecyclerView mediaCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_view_contact);

        intIds();
        performActions();
        setAdapter();
    }

    private void intIds(){
        mediaCycle = findViewById(R.id.mediaCycle);
        back = findViewById(R.id.back);
        options = findViewById(R.id.options);
    }

    private void performActions(){
        back.setOnClickListener(this);
        options.setOnClickListener(this);
    }

    private void setAdapter(){
        MediaAdapter mediaAdapter = new MediaAdapter(this);
        mediaCycle.setAdapter(mediaAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mediaCycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.options:
                PopupMenu popupMenu = new PopupMenu(ViewContactActivity.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.contacts_options_items, popupMenu.getMenu());

//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        switch (menuItem.getItemId()){
//                            case R.id.Share:
//                                startActivity(new Intent(ViewContactActivity.this, ViewContactActivity.class));
//                                break;
//                        }
//
////                        Toast.makeText(ChatActivity.this,"You Clicked:" + menuItem.getTitle(),Toast.LENGTH_LONG).show();
//                        return true;
//                    }
//                });

                popupMenu.show();
                break;
        }
    }
}
