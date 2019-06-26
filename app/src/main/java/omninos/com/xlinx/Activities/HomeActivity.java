package omninos.com.xlinx.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.sdsmdg.harjot.vectormaster.VectorMasterView;
import com.sdsmdg.harjot.vectormaster.models.PathModel;

import omninos.com.xlinx.CurvedBottomNavigation.CurvedBottomNavigation;
import omninos.com.xlinx.Fragments.ContactsFragment;
import omninos.com.xlinx.Fragments.MessageFragment;
import omninos.com.xlinx.Fragments.TimelineFragment;
import omninos.com.xlinx.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private CurvedBottomNavigation bottomNavigationView;
    private VectorMasterView fab, fab1, fab2;
    private RelativeLayout lin_id;
    private PathModel outline;
    private Menu menu;
    private DrawerLayout drawer;
    private float slideX;
    private CoordinatorLayout content;
    private ImageView navigation;
    private BottomSheetBehavior sheetBehavior;
    private ImageView profile, searchIconImageView;
    private LinearLayout callOptions;
    private RecyclerView recyclerView;
    private BottomNavigationViewEx bottomNavigationViewEx;
    private TextView newGroup, settings, wallet, store, Call, InviteAFriend, help, chats, contacts, momentsTextView;
    private LinearLayout contactsOptions;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.light_blue);
        setContentView(R.layout.activity_home);

        intIds();
        navigationIds();
        performActions();
        onSlide();

        fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container, new MessageFragment()).commit();

//        menu = bottomNavigationView.getMenu();

        //first
//        lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
//        fab.setVisibility(View.GONE);
//        fab1.setVisibility(View.VISIBLE);
//        fab2.setVisibility(View.GONE);
//
//        menu.getItem(0).setIcon(R.drawable.ic_telephone);
//        menu.getItem(1).setIcon(null);
//        menu.getItem(2).setIcon(R.drawable.ic_user);
//                drawAnimation(fab1);

//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.container, new MessageFragment());
//        transaction.commit();
    }

    private void intIds() {
        profile = findViewById(R.id.profile);
        callOptions = findViewById(R.id.callOptions);
        drawer = findViewById(R.id.drawer);
        content = findViewById(R.id.content);
        navigation = findViewById(R.id.navigation);
        Call = findViewById(R.id.Call);
        contactsOptions = findViewById(R.id.contactsOptions);
        momentsTextView = findViewById(R.id.moments_text_view);
        chats = findViewById(R.id.chats);
        contacts = findViewById(R.id.contacts);
        searchIconImageView = findViewById(R.id.search_icon);

        bottomNavigationViewEx = findViewById(R.id.bottom_nav);
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setIconSize(25, 25);
        bottomNavigationViewEx.setTextSize(12);
        bottomNavigationViewEx.setCurrentItem(1);

//        bottomNavigationView = findViewById(R.id.bottom_nav);
//        fab = findViewById(R.id.fab);
//        fab1 = findViewById(R.id.fab1);
//        fab2 = findViewById(R.id.fab2);
//        lin_id = findViewById(R.id.lin_id);
        recyclerView = findViewById(R.id.ContactsCycle);
        LinearLayout BottomSheetLayout = findViewById(R.id.BottomSheetMainLayout);
        sheetBehavior = BottomSheetBehavior.from(BottomSheetLayout);
//        bottomNavigationView.inflateMenu(R.menu.curved_items);
//        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void navigationIds() {
        newGroup = findViewById(R.id.newGroup);
        settings = findViewById(R.id.settings);
        wallet = findViewById(R.id.wallet);
        store = findViewById(R.id.store);
        InviteAFriend = findViewById(R.id.InviteAFriend);
        help = findViewById(R.id.help);

        newGroup.setOnClickListener(this);
        settings.setOnClickListener(this);
        wallet.setOnClickListener(this);
        store.setOnClickListener(this);
        InviteAFriend.setOnClickListener(this);
        help.setOnClickListener(this);
        Call.setOnClickListener(this);
    }

    private void performActions() {
        profile.setOnClickListener(this);
        navigation.setOnClickListener(this);
        drawer.setScrimColor(Color.TRANSPARENT);

        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.phone:
                        fm.beginTransaction().replace(R.id.container, new TimelineFragment()).commit();
                        contactsOptions.setVisibility(View.GONE);
                        profile.setVisibility(View.VISIBLE);
                        momentsTextView.setVisibility(View.VISIBLE);
                        contacts.setVisibility(View.GONE);
                        chats.setVisibility(View.GONE);
                        searchIconImageView.setVisibility(View.GONE);
                        break;

                    case R.id.messages:
                        fm.beginTransaction().replace(R.id.container, new MessageFragment()).commit();
                        contactsOptions.setVisibility(View.GONE);
                        profile.setVisibility(View.GONE);
                        momentsTextView.setVisibility(View.GONE);
                        chats.setVisibility(View.VISIBLE);
                        searchIconImageView.setVisibility(View.VISIBLE);
                        contacts.setVisibility(View.GONE);
                        break;

                    case R.id.contacts:
                        fm.beginTransaction().replace(R.id.container, new ContactsFragment()).commit();
                        contactsOptions.setVisibility(View.VISIBLE);
                        profile.setVisibility(View.GONE);
                        momentsTextView.setVisibility(View.GONE);
                        contacts.setVisibility(View.VISIBLE);
                        chats.setVisibility(View.GONE);
                        searchIconImageView.setVisibility(View.GONE);
                        break;
                }

                return true;
            }
        });
    }

    private void onSlide() {
        final ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                slideX = drawerView.getWidth() * slideOffset;
                content.setTranslationX(slideX);
                content.setVisibility(View.VISIBLE);
            }
        };
        drawer.addDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigation:
                drawer.openDrawer(Gravity.START);

                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                }

                break;

            case R.id.profile:
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
//                bottomSheetLayout();
                break;

            case R.id.newGroup:
                startActivity(new Intent(HomeActivity.this, NewGroupActivity.class));
                break;

            case R.id.settings:
                startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
                break;

            case R.id.wallet:
                startActivity(new Intent(HomeActivity.this, WalletActivity.class));
                break;

            case R.id.store:
                startActivity(new Intent(HomeActivity.this, StoreActivity.class));
                break;

            case R.id.InviteAFriend:
                startActivity(new Intent(HomeActivity.this, InviteFriendActivity.class));
                break;

            case R.id.Call:
                startActivity(new Intent(HomeActivity.this, CallActivity.class));
                break;

            case R.id.help:
                startActivity(new Intent(HomeActivity.this, HelpActivity.class));
                break;
        }
    }

//    private void bottomSheetLayout() {
//
//        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//
//        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                switch (newState) {
//                    case BottomSheetBehavior.STATE_HIDDEN:
//                        break;
//                    case BottomSheetBehavior.STATE_EXPANDED:
//                        break;
//                    case BottomSheetBehavior.STATE_COLLAPSED:
//                        break;
//                    case BottomSheetBehavior.STATE_DRAGGING:
//                        break;
//                    case BottomSheetBehavior.STATE_SETTLING:
//                        break;
//                }
//            }
//
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//
//            }
//        });
//
//    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//        switch (menuItem.getItemId()) {
//            case R.id.phone:
//                draw(6);
//                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
//                fab.setVisibility(View.VISIBLE);
//                fab1.setVisibility(View.GONE);
//                fab2.setVisibility(View.GONE);
//                menu.getItem(0).setIcon(null);
//                menu.getItem(1).setIcon(R.drawable.ic_speech_bubble);
//                menu.getItem(2).setIcon(R.drawable.ic_user);
//                drawAnimation(fab);
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.container, new CallFragment());
//                transaction.commit();
//                callOptions.setVisibility(View.VISIBLE);
//                break;
//
//            case R.id.messages:
//                draw(2);
//                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
//                fab.setVisibility(View.GONE);
//                fab1.setVisibility(View.VISIBLE);
//                fab2.setVisibility(View.GONE);
//
//                menu.getItem(0).setIcon(R.drawable.ic_telephone);
//                menu.getItem(1).setIcon(null);
//                menu.getItem(2).setIcon(R.drawable.ic_user);
//                drawAnimation(fab1);
//                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
//                transaction1.replace(R.id.container, new MessageFragment());
//                transaction1.commit();
//                callOptions.setVisibility(View.GONE);
//                break;
//
//            case R.id.contacts:
//                draw();
//                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
//                fab.setVisibility(View.GONE);
//                fab1.setVisibility(View.GONE);
//                fab2.setVisibility(View.VISIBLE);
//                menu.getItem(0).setIcon(R.drawable.ic_telephone);
//                menu.getItem(1).setIcon(R.drawable.ic_speech_bubble);
//                menu.getItem(2).setIcon(null);
//                drawAnimation(fab2);
//                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
//                transaction2.replace(R.id.container, new ContactsFragment());
//                transaction2.commit();
//
//                callOptions.setVisibility(View.GONE);
//                break;
//        }
//
//        return true;
//    }

//    private void draw() {
//        bottomNavigationView.mFirstCurveStartPoint.set((bottomNavigationView.mNavigationBarWidth * 10 / 12) - (bottomNavigationView.CURVE_CIRCLE_RADIUS * 2) - (bottomNavigationView.CURVE_CIRCLE_RADIUS / 3), 0);
//        // the coordinates (x,y) of the end point after curve
//        bottomNavigationView.mFirstCurveEndPoint.set(bottomNavigationView.mNavigationBarWidth * 10 / 12, bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS / 4));
//        // same thing for the second curve
//        bottomNavigationView.mSecondCurveStartPoint = bottomNavigationView.mFirstCurveEndPoint;
//        bottomNavigationView.mSecondCurveEndPoint.set((bottomNavigationView.mNavigationBarWidth * 10 / 12) + (bottomNavigationView.CURVE_CIRCLE_RADIUS * 2) + (bottomNavigationView.CURVE_CIRCLE_RADIUS / 3), 0);
//
//        // the coordinates (x,y)  of the 1st control point on a cubic curve
//        bottomNavigationView.mFirstCurveControlPoint1.set(bottomNavigationView.mFirstCurveStartPoint.x + bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS / 4), bottomNavigationView.mFirstCurveStartPoint.y);
//        // the coordinates (x,y)  of the 2nd control point on a cubic curve
//        bottomNavigationView.mFirstCurveControlPoint2.set(bottomNavigationView.mFirstCurveEndPoint.x - (bottomNavigationView.CURVE_CIRCLE_RADIUS * 2) + bottomNavigationView.CURVE_CIRCLE_RADIUS, bottomNavigationView.mFirstCurveEndPoint.y);
//
//        bottomNavigationView.mSecondCurveControlPoint1.set(bottomNavigationView.mSecondCurveStartPoint.x + (bottomNavigationView.CURVE_CIRCLE_RADIUS * 2) - bottomNavigationView.CURVE_CIRCLE_RADIUS, bottomNavigationView.mSecondCurveStartPoint.y);
//        bottomNavigationView.mSecondCurveControlPoint2.set(bottomNavigationView.mSecondCurveEndPoint.x - (bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS / 4)), bottomNavigationView.mSecondCurveEndPoint.y);
//
//
//    }
//
//    private void drawAnimation(final VectorMasterView fab) {
//        outline = fab.getPathModelByName("outline");
//        outline.setStrokeColor(Color.WHITE);
//        outline.setTrimPathEnd(0.0f);
//
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
//        valueAnimator.setDuration(1000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                outline.setTrimPathEnd((Float) animation.getAnimatedValue());
//                fab.update();
//            }
//        });
//
//        valueAnimator.start();
//    }
//
//    private void draw(int i) {
//        bottomNavigationView.mFirstCurveStartPoint.set((bottomNavigationView.mNavigationBarWidth / i) - (bottomNavigationView.CURVE_CIRCLE_RADIUS * 2) - (bottomNavigationView.CURVE_CIRCLE_RADIUS / 3), 0);
//        // the coordinates (x,y) of the end point after curve
//        bottomNavigationView.mFirstCurveEndPoint.set(bottomNavigationView.mNavigationBarWidth / i, bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS / 4));
//        // same thing for the second curve
//        bottomNavigationView.mSecondCurveStartPoint = bottomNavigationView.mFirstCurveEndPoint;
//        bottomNavigationView.mSecondCurveEndPoint.set((bottomNavigationView.mNavigationBarWidth / i) + (bottomNavigationView.CURVE_CIRCLE_RADIUS * 2) + (bottomNavigationView.CURVE_CIRCLE_RADIUS / 3), 0);
//
//        // the coordinates (x,y)  of the 1st control point on a cubic curve
//        bottomNavigationView.mFirstCurveControlPoint1.set(bottomNavigationView.mFirstCurveStartPoint.x + bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS / 4), bottomNavigationView.mFirstCurveStartPoint.y);
//        // the coordinates (x,y)  of the 2nd control point on a cubic curve
//        bottomNavigationView.mFirstCurveControlPoint2.set(bottomNavigationView.mFirstCurveEndPoint.x - (bottomNavigationView.CURVE_CIRCLE_RADIUS * 2) + bottomNavigationView.CURVE_CIRCLE_RADIUS, bottomNavigationView.mFirstCurveEndPoint.y);
//
//        bottomNavigationView.mSecondCurveControlPoint1.set(bottomNavigationView.mSecondCurveStartPoint.x + (bottomNavigationView.CURVE_CIRCLE_RADIUS * 2) - bottomNavigationView.CURVE_CIRCLE_RADIUS, bottomNavigationView.mSecondCurveStartPoint.y);
//        bottomNavigationView.mSecondCurveControlPoint2.set(bottomNavigationView.mSecondCurveEndPoint.x - (bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS / 4)), bottomNavigationView.mSecondCurveEndPoint.y);
//
//
//    }
}
