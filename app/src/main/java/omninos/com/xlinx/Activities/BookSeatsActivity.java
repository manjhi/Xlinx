package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import omninos.com.xlinx.Adapters.BookSeatsAdapter;
import omninos.com.xlinx.R;

public class BookSeatsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private Button BookTickets;
    private RecyclerView bookSeatsCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_book_seats);

        intIds();
        performActions();
        setAdapter();
    }

    private void intIds(){
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        bookSeatsCycle = findViewById(R.id.bookSeatsCycle);
        BookTickets = findViewById(R.id.BookTickets);
    }

    private void performActions(){
        back.setOnClickListener(this);
        bar_name.setText("Book Now");
        BookTickets.setOnClickListener(this);
    }

    private void setAdapter(){
        BookSeatsAdapter bookSeatsAdapter = new BookSeatsAdapter(this);
        bookSeatsCycle.setAdapter(bookSeatsAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        bookSeatsCycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;

            case R.id.BookTickets:
                startActivity(new Intent(BookSeatsActivity.this, AfterSeatBookingActivity.class));
                break;
        }
    }
}
