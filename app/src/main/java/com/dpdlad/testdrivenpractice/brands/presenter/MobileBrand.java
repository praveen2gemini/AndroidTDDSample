package com.dpdlad.testdrivenpractice.brands.presenter;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

/**
 * @author Praveen on 30/08/18.
 */
public class MobileBrand implements Parcelable {

    public static final Creator<MobileBrand> CREATOR = new Creator<MobileBrand>() {
        @Override
        public MobileBrand createFromParcel(Parcel in) {
            return new MobileBrand(in);
        }

        @Override
        public MobileBrand[] newArray(int size) {
            return new MobileBrand[size];
        }
    };
    private String brandName;
    private int brandId;
    private int brandPrice;
    private String brandVersion;

    private MobileBrand() {

    }

    protected MobileBrand(Parcel in) {
        brandName = in.readString();
        brandId = in.readInt();
        brandPrice = in.readInt();
        brandVersion = in.readString();
    }

    public static MobileBrand createMobileBrand(String brandName) {
        MobileBrand mobileBrand = new MobileBrand();
        mobileBrand.brandName = brandName;
        mobileBrand.brandId = brandName.hashCode();
        mobileBrand.brandPrice = new Random().nextInt(10000);
        mobileBrand.brandVersion = "V1" + (mobileBrand.brandPrice % 122);
        return mobileBrand;
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getBrandPrice() {
        return brandPrice;
    }

    public void setBrandPrice(int brandPrice) {
        this.brandPrice = brandPrice;
    }

    public String getBrandVersion() {
        return brandVersion;
    }

    public void setBrandVersion(String brandVersion) {
        this.brandVersion = brandVersion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(brandName);
        parcel.writeInt(brandId);
        parcel.writeInt(brandPrice);
        parcel.writeString(brandVersion);
    }

    @Override
    public String toString() {
        return brandName;
    }
}
