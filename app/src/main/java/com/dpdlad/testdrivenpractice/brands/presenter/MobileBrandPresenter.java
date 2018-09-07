package com.dpdlad.testdrivenpractice.brands.presenter;

import java.util.ArrayList;

/**
 * @author Praveen on 30/08/18.
 */
public interface MobileBrandPresenter {

    void fetchAllMobileBrands();

    interface View {
        void showProgress();

        void hideProgress();

        void updateMobileBrands(ArrayList<MobileBrand> mobileBrands);
    }
}
