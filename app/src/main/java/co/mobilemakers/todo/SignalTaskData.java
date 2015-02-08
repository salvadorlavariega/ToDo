package co.mobilemakers.todo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by root on 6/02/15.
 */
public class SignalTaskData implements Parcelable {

    private String tarkName;

    public String getTarkName() {
        return tarkName;
    }
    public SignalTaskData(Parcel in){
        readFromParcel(in);
    }

    public SignalTaskData(){}


    public void setTarkName(String tarkName) {
        this.tarkName = tarkName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tarkName);

    }

    private void readFromParcel(Parcel in){
        tarkName = in.readString();

    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public SignalTaskData createFromParcel(Parcel in) {
            return new SignalTaskData(in);
        }
        public SignalTaskData[] newArray(int size)
        { return new SignalTaskData[size];
        }

    };
}
