package com.dpdlad.testdrivenpractice.brands.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dpdlad.testdrivenpractice.R;
import com.dpdlad.testdrivenpractice.brands.presenter.MobileBrand;

import java.util.ArrayList;

/**
 * @author Praveen on 30/08/18.
 */
public class MobileBrandAdapter extends RecyclerView.Adapter<MobileBrandAdapter.BrandHolder> {

    private Context context;
    private ArrayList<MobileBrand> mobileBrands;
    private OnBrandClickListener brandClickListener;


    public MobileBrandAdapter(Context context) {
        this.context = context;
    }

    public void updateMobileBrands(ArrayList<MobileBrand> mobileBrands) {
        this.mobileBrands = mobileBrands;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BrandHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.view_single_mobile_brand_detail, null);
        return new BrandHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandHolder brandHolder, int i) {
        brandHolder.recycleBrandInfo(mobileBrands.get(i), brandClickListener);
    }

    @Override
    public int getItemCount() {
        return (null == mobileBrands) ? 0 : mobileBrands.size();
    }

    public void setBrandClickListener(OnBrandClickListener brandClickListener) {
        this.brandClickListener = brandClickListener;
    }

    public interface OnBrandClickListener {
        void onBrandSelected(MobileBrand mobileBrand);
    }

    public static class BrandHolder extends RecyclerView.ViewHolder {

        private TextView brandIdView, brandNameView, brandPriceView, brandVersionView;
        private View itemView;

        public BrandHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            brandIdView = itemView.findViewById(R.id.brand_id);
            brandNameView = itemView.findViewById(R.id.brand_name);
            brandPriceView = itemView.findViewById(R.id.brand_price);
            brandVersionView = itemView.findViewById(R.id.brand_version);
        }

        public String getItemName() {
            return brandNameView.getText().toString();
        }

        void recycleBrandInfo(final MobileBrand mobileBrand, final OnBrandClickListener brandClickListener) {
            if (null != mobileBrand) {
                brandIdView.setText("Brand Id: \n" + mobileBrand.getBrandId());
                brandNameView.setText("Brand Name: \n" + mobileBrand.getBrandName());
                brandPriceView.setText("Brand Price: \n" + mobileBrand.getBrandPrice());
                brandVersionView.setText("Brand Version: \n" + mobileBrand.getBrandVersion());
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        brandClickListener.onBrandSelected(mobileBrand);
                    }
                });
            }
        }

    }
}
