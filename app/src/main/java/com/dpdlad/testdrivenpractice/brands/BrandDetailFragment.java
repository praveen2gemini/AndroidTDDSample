package com.dpdlad.testdrivenpractice.brands;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dpdlad.testdrivenpractice.R;
import com.dpdlad.testdrivenpractice.brands.presenter.MobileBrand;

/**
 * @author Praveen on 06/09/18.
 */
public class BrandDetailFragment extends Fragment {

    private TextView brandIdView, brandNameView, brandPriceView, brandVersionView;

    public static Fragment newInstance(MobileBrand mobileBrand) {
        BrandDetailFragment detailFragment = new BrandDetailFragment();
        Bundle arg = new Bundle();
        arg.putParcelable(BrandDetailActivity.KEY_MOBILE_BRAND, mobileBrand);
        detailFragment.setArguments(arg);
        return detailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_brand_detail, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(@NonNull View itemView) {
        brandIdView = itemView.findViewById(R.id.brand_id);
        brandNameView = itemView.findViewById(R.id.brand_name);
        brandPriceView = itemView.findViewById(R.id.brand_price);
        brandVersionView = itemView.findViewById(R.id.brand_version);
    }

    private void updateBrandDetails() {
        if (null == getArguments()) return;
        MobileBrand mobileBrand = getArguments().getParcelable(BrandDetailActivity.KEY_MOBILE_BRAND);
        if (null != mobileBrand) {
            brandIdView.setText("Brand Id: \n" + mobileBrand.getBrandId());
            brandNameView.setText("Brand Name: \n" + mobileBrand.getBrandName());
            brandPriceView.setText("Brand Price: \n" + mobileBrand.getBrandPrice());
            brandVersionView.setText("Brand Version: \n" + mobileBrand.getBrandVersion());
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        updateBrandDetails();
    }
}
