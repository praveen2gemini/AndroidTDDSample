package com.dpdlad.testdrivenpractice.brands;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dpdlad.testdrivenpractice.R;
import com.dpdlad.testdrivenpractice.brands.presenter.MobileBrand;

/**
 * @author Praveen on 06/09/18.
 */
public class BrandDetailActivity extends AppCompatActivity {

    public static final String KEY_MOBILE_BRAND = "KEY_MOBILE_BRAND";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_detail);
        if (null == savedInstanceState) {
            MobileBrand mobileBrand = getIntent().getParcelableExtra(KEY_MOBILE_BRAND);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_frame, BrandDetailFragment.newInstance(mobileBrand))
                    .commit();
        }
    }

    public static Intent startIntent(Context context, MobileBrand mobileBrand) {
        Intent brandIntent = new Intent(context, BrandDetailActivity.class);
        brandIntent.putExtra(KEY_MOBILE_BRAND, mobileBrand);
        return brandIntent;
    }
}
