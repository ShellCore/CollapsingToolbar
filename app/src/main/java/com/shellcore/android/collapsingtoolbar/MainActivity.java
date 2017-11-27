package com.shellcore.android.collapsingtoolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;

import com.shellcore.android.collapsingtoolbar.fillings.Brie;
import com.shellcore.android.collapsingtoolbar.fillings.Camembert;
import com.shellcore.android.collapsingtoolbar.fillings.Cheddar;
import com.shellcore.android.collapsingtoolbar.fillings.Cheese;
import com.shellcore.android.collapsingtoolbar.fillings.Feta;
import com.shellcore.android.collapsingtoolbar.fillings.Gorgonzola;
import com.shellcore.android.collapsingtoolbar.fillings.Mahones;
import com.shellcore.android.collapsingtoolbar.fillings.Manchego;
import com.shellcore.android.collapsingtoolbar.fillings.Mozzarella;
import com.shellcore.android.collapsingtoolbar.fillings.Parmesano;
import com.shellcore.android.collapsingtoolbar.fillings.Roquefort;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CheeseItemListener {

    // Components
    @BindView(R.id.img_toolbar)
    ImageView imgToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.rec_list)
    RecyclerView recList;
    @BindView(R.id.btn_add)
    FloatingActionButton btnAdd;
    @BindView(R.id.coordinator_container)
    CoordinatorLayout coordinatorContainer;

    // Variables
    private List<Cheese> cheeses;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupToolbar();

        initializeData();
        setupRecyclerView();
    }

    @OnClick(R.id.btn_add)
    public void payShopCart() {
//        Snackbar.make(coordinatorContainer, R.string.btn_add_click_message, Snackbar.LENGTH_SHORT)
//                        .show();

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setView(getLayoutInflater().inflate(R.layout.checkout_dialog, null))
                /*.setTitle(R.string.checkout_title)
                .setMessage(R.string.checkout_question)
                .setIcon(R.drawable.ic_shopping_cart)*/
                .setPositiveButton(getString(R.string.action_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        navigateToCheckoutActivity();
                    }
                })
                .setNegativeButton(getString(R.string.action_cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();

        Button btnCancel = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        btnCancel.setTextColor(getResources().getColor(R.color.colorAccent));

        Button btnConfirm = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        btnConfirm.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    public void addCheese(Cheese cheese) {

    }

    @Override
    public void selectCheese(Cheese cheese) {

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    private void initializeData() {
        cheeses = new ArrayList();
        cheeses.add(new Brie());
        cheeses.add(new Camembert());
        cheeses.add(new Cheddar());
        cheeses.add(new Feta());
        cheeses.add(new Gorgonzola());
        cheeses.add(new Mahones());
        cheeses.add(new Manchego());
        cheeses.add(new Mozzarella());
        cheeses.add(new Parmesano());
        cheeses.add(new Roquefort());
    }

    private void setupRecyclerView() {
        adapter = new DataAdapter(cheeses, this);
        recList.setLayoutManager(new LinearLayoutManager(this));
//        int numColumns = 2;
//        recList.setLayoutManager(new StaggeredGridLayoutManager(numColumns, StaggeredGridLayoutManager.VERTICAL));

        recList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recList.setAdapter(adapter);

        boolean iWantSwipes = true;
        if (iWantSwipes) {
            recList.setHasFixedSize(false);
            setupItemTouchHelper();
        } else {
            recList.setHasFixedSize(true);
        }

    }

    private void navigateToCheckoutActivity() {
        startActivity(new Intent(this, CheckoutActivity.class));
    }

    private void setupItemTouchHelper() {
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                if (direction == ItemTouchHelper.LEFT) {
                    Snackbar.make(coordinatorContainer, "Swipe a la izquierda", Snackbar.LENGTH_SHORT)
                            .show();
                } else {
                    Snackbar.make(coordinatorContainer, "Swipe a la derecha", Snackbar.LENGTH_SHORT)
                            .show();
                }

                int position = viewHolder.getAdapterPosition();
                adapter.removeItem(position);
            }
        };

        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recList);
    }
}
