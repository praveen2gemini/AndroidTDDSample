package com.dpdlad.testdrivenpractice.brands.presenter;

import java.util.ArrayList;

/**
 * @author Praveen on 30/08/18.
 */
public class MobileBrandPresenterImpl implements MobileBrandPresenter {

    private MobileBrandPresenter.View view;

    public MobileBrandPresenterImpl(MobileBrandPresenter.View view) {
        this.view = view;
    }

    @Override
    public void fetchAllMobileBrands() {
        if (null == view) {
            throw new NullPointerException("View can not be NULL referenced!!");
        }

        view.showProgress();
        MobileBrand mobileBrand;
        ArrayList<MobileBrand> allBrands = new ArrayList<>();
        allBrands.add(MobileBrand.createMobileBrand("Samsung"));
        allBrands.add(MobileBrand.createMobileBrand("Apple"));
        allBrands.add(MobileBrand.createMobileBrand("Fujitsu"));
        allBrands.add(MobileBrand.createMobileBrand("Redmi"));
        allBrands.add(MobileBrand.createMobileBrand("SONY"));
        allBrands.add(MobileBrand.createMobileBrand("Moto"));
        allBrands.add(MobileBrand.createMobileBrand("Carbon"));
        allBrands.add(MobileBrand.createMobileBrand("Micromax"));

        for (int i = 0; i < 20; i++) {
            mobileBrand = MobileBrand.createMobileBrand("Samsung" + i);
            allBrands.add(mobileBrand);
        }
        view.hideProgress();
        view.updateMobileBrands(allBrands);
    }
}
