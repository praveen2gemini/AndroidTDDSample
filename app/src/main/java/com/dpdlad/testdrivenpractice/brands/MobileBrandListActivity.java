package com.dpdlad.testdrivenpractice.brands;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.dpdlad.testdrivenpractice.R;
import com.dpdlad.testdrivenpractice.brands.adapter.MobileBrandAdapter;
import com.dpdlad.testdrivenpractice.brands.presenter.MobileBrand;
import com.dpdlad.testdrivenpractice.brands.presenter.MobileBrandPresenter;
import com.dpdlad.testdrivenpractice.brands.presenter.MobileBrandPresenterImpl;

import java.util.ArrayList;

/**
 * @author Praveen on 29/08/18.
 */
public class MobileBrandListActivity extends AppCompatActivity implements MobileBrandPresenter.View, MobileBrandAdapter.OnBrandClickListener {

    private View progressView;
    private RecyclerView recyclerView;
    private MobileBrandPresenter brandPresenter;
    private MobileBrandAdapter mobileBrandAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_brand_details);
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        brandPresenter.fetchAllMobileBrands();
    }

    private void initViews() {
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        progressView = findViewById(R.id.progress_view);
        brandPresenter = new MobileBrandPresenterImpl(this);
        mobileBrandAdapter = new MobileBrandAdapter(this);
        mobileBrandAdapter.setBrandClickListener(this);
        recyclerView.setAdapter(mobileBrandAdapter);
    }

    @Override
    public void showProgress() {
        progressView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void updateMobileBrands(ArrayList<MobileBrand> mobileBrands) {
        mobileBrandAdapter.updateMobileBrands(mobileBrands);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean itemSelected = super.onOptionsItemSelected(item);
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            itemSelected = true;
        }

        return itemSelected;
    }

    @Override
    public void onBrandSelected(MobileBrand mobileBrand) {
        startActivity(BrandDetailActivity.startIntent(this, mobileBrand));
    }
}
