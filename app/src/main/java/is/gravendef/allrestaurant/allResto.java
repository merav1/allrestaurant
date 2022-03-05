package is.gravendef.allrestaurant;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class allResto {

    private String mName;
    private boolean mOnline;
    private ImageView imageview;
    private TextView textView;

    public allResto(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastrestoId = 0;
    public void setImage(ImageView image)
    {
        this.imageview=image;
    }
    public ImageView getImage()
    {
        return this.imageview;
    }
    public static ArrayList<allResto> createAllRestoList(int numResto) {
        ArrayList<allResto> allRestos = new ArrayList<allResto>();

        for (int i = 1; i <= numResto; i++) {
            allRestos.add(new allResto("Person " + ++lastrestoId, i <= numResto / 2));
        }

        return allRestos;
    }
    public static ArrayList<allResto> createnameList(int numResto) {
        ArrayList<allResto> name1 = new ArrayList<allResto>();

        for (int i = 1; i <= numResto; i++) {
            name1.add(new allResto("Person " + ++lastrestoId, i <= numResto / 2));
        }

        return name1;
    }

    public void setText(TextView textView) {
        this.textView=textView;
    }
}
