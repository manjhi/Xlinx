package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import omninos.com.xlinx.Adapters.BookMovieTicketsPagerAdapter;
import omninos.com.xlinx.Adapters.BookNowTicketsAdapter;
import omninos.com.xlinx.Adapters.UpcomingMoviesAdapter;
import omninos.com.xlinx.R;

public class BookMoviesTickets extends AppCompatActivity implements View.OnClickListener {
    private TextView bar_name;
    private ImageView back;
    private ViewPager viewPager;
    private Timer timer;
    private int currentPage = 0;
    private Button all, punjabi, hindi, english;
    private RecyclerView booknowrv, moviesrv;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.blue);
        setContentView(R.layout.activity_book_movies_tickets);

        intIds();
        performActions();
        setAdapter();
    }

    private void intIds() {
        bar_name = findViewById(R.id.bar_name);
        back = findViewById(R.id.back);
        viewPager = findViewById(R.id.pager);
        moviesrv = findViewById(R.id.moviesrv);
        booknowrv = findViewById(R.id.booknowrv);
        all = findViewById(R.id.all);
        punjabi = findViewById(R.id.punjabi);
        hindi = findViewById(R.id.hindi);
        english = findViewById(R.id.english);
    }

    private void performActions() {
        back.setOnClickListener(this);
        bar_name.setText("Book Movies Ticket");
        all.setOnClickListener(this);
        punjabi.setOnClickListener(this);
        hindi.setOnClickListener(this);
        english.setOnClickListener(this);
    }

    private void setAdapter() {
        BookMovieTicketsPagerAdapter bookMovieTicketsPagerAdapter = new BookMovieTicketsPagerAdapter(this);
        viewPager.setAdapter(bookMovieTicketsPagerAdapter);
        timer();

        UpcomingMoviesAdapter upcomingMoviesAdapter = new UpcomingMoviesAdapter(this);
        moviesrv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        moviesrv.setAdapter(upcomingMoviesAdapter);

        BookNowTicketsAdapter bookNowTicketsAdapter = new BookNowTicketsAdapter(this, new BookNowTicketsAdapter.BookNow() {
            @Override
            public void Book(int position) {
                startActivity(new Intent(BookMoviesTickets.this, BookNowActivity.class));
            }
        });
        booknowrv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        booknowrv.setAdapter(bookNowTicketsAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;

            case R.id.all:
                all.setTextColor(Color.parseColor("#ffffff"));
                all.setBackground(getDrawable(R.drawable.bg_btn_blue_round_corners));
                punjabi.setTextColor(Color.parseColor("#000000"));
                punjabi.setBackground(getDrawable(R.drawable.background_blue_round_corners));
                hindi.setTextColor(Color.parseColor("#000000"));
                hindi.setBackground(getDrawable(R.drawable.background_blue_round_corners));
                english.setTextColor(Color.parseColor("#000000"));
                english.setBackground(getDrawable(R.drawable.background_blue_round_corners));
                break;

            case R.id.punjabi:
                punjabi.setTextColor(Color.parseColor("#ffffff"));
                punjabi.setBackground(getDrawable(R.drawable.bg_btn_blue_round_corners));
                all.setTextColor(Color.parseColor("#000000"));
                all.setBackground(getDrawable(R.drawable.background_blue_round_corners));
                hindi.setTextColor(Color.parseColor("#000000"));
                hindi.setBackground(getDrawable(R.drawable.background_blue_round_corners));
                english.setTextColor(Color.parseColor("#000000"));
                english.setBackground(getDrawable(R.drawable.background_blue_round_corners));
                break;

            case R.id.hindi:
                hindi.setTextColor(Color.parseColor("#ffffff"));
                hindi.setBackground(getDrawable(R.drawable.bg_btn_blue_round_corners));
                all.setTextColor(Color.parseColor("#000000"));
                all.setBackground(getDrawable(R.drawable.background_blue_round_corners));
                punjabi.setTextColor(Color.parseColor("#000000"));
                punjabi.setBackground(getDrawable(R.drawable.background_blue_round_corners));
                english.setTextColor(Color.parseColor("#000000"));
                english.setBackground(getDrawable(R.drawable.background_blue_round_corners));
                break;

            case R.id.english:
                english.setTextColor(Color.parseColor("#ffffff"));
                english.setBackground(getDrawable(R.drawable.bg_btn_blue_round_corners));
                all.setTextColor(Color.parseColor("#000000"));
                all.setBackground(getDrawable(R.drawable.background_blue_round_corners));
                punjabi.setTextColor(Color.parseColor("#000000"));
                punjabi.setBackground(getDrawable(R.drawable.background_blue_round_corners));
                hindi.setTextColor(Color.parseColor("#000000"));
                hindi.setBackground(getDrawable(R.drawable.background_blue_round_corners));
                break;
        }
    }

    private void timer() {
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 5) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }
}

