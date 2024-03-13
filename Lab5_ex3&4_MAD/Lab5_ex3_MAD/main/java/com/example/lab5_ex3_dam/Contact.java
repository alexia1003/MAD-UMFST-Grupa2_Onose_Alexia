package com.example.lab5_ex3_dam;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String email;
    private String linkedin;
    private int photoResourceId;

    public Contact(String name, String surname, String phone, String address, String email, String linkedin, int photoResourceId) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.linkedin = linkedin;
        this.photoResourceId = photoResourceId;
    }

    // Citire info.
    protected Contact(Parcel in) {
        name = in.readString();
        surname = in.readString();
        phone = in.readString();
        address = in.readString();
        email = in.readString();
        linkedin = in.readString();
        photoResourceId = in.readInt(); //
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        // Creare instanta si preluare info. scrise cu "writeToParcel"
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }
        // Creare vector nou cu clasa Parcelable
        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public int getPhotoResourceId() {
        return photoResourceId; // Return photo resource ID
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    //  Return set special de obiecte al cls. Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    // Transforma obiectele in tipul Parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(phone);
        dest.writeString(address);
        dest.writeString(email);
        dest.writeString(linkedin);
        dest.writeInt(photoResourceId);
    }
}
