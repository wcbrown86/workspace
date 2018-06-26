package com.example.williambrown.inclass3;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by williambrown on 5/30/17.
 */

public class Student implements Parcelable {

    public String studentName;
    public String studentEmail;
    public String studentDepartment;
    public int studentMood;

    public Student (String name, String email, String department, int mood){

        studentName = name;
        studentEmail = email;
        studentDepartment = department;
        studentMood = mood;
    }

    protected Student(Parcel in) {
        studentName = in.readString();
        studentEmail = in.readString();
        studentDepartment = in.readString();
        studentMood = in.readInt();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(studentName);
        dest.writeString(studentEmail);
        dest.writeString(studentDepartment);
        dest.writeInt(studentMood);
    }
}
