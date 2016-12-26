package ashu.mapdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by apple on 26/12/16.
 */

public class AdapterPager extends PagerAdapter {

    LatLng sydney = new LatLng(-34, 151);
    LatLng a1 = new LatLng(-30, 152);
    LatLng a2 = new LatLng(-27, 147);
    LatLng a3 = new LatLng(-25, 149);
    LatLng a4 = new LatLng(-29, 141);
    LatLng a5 = new LatLng(-29, 144);
    LatLng a6 = new LatLng(-29, 131);
    LatLng a7 = new LatLng(-29, 121);

    private int [] ar = new int[]{R.drawable.a1,
                    R.drawable.a2,
                    R.drawable.a3,
                    R.drawable.a4,
                    R.drawable.a5,
                    R.drawable.a6,
                    R.drawable.about_back,
                    R.drawable.mila};


    private Context context;
    private LatLng latLng;
    private ImageView imgView;

    private Intent intent;

    public AdapterPager(Context context){
        this.context = context;
    }

    private void setLatLong(LatLng val){
        this.latLng = val;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return ar.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);

    }

    @Override
    public float getPageWidth(int position) {
        return 0.7f;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.pager_item, container,
                false);

        imgView = (ImageView) itemView.findViewById(R.id.imageView);

        imgView.setImageResource(ar[position]);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(context, ExpandedView.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if(position == 0){
                    intent.putExtra("latlng", sydney.toString());
                    Log.d("itemclicked", sydney + "");
                }
                if(position == 1){
                    intent.putExtra("latlng", a1.toString());

                }
                if(position == 2){
                    intent.putExtra("latlng", a2.toString());
                }
                if(position == 3){
                    intent.putExtra("latlng", a3.toString());
                }
                if(position == 4){
                    intent.putExtra("latlng", a4.toString());
                }
                if(position == 5){
                    intent.putExtra("latlng", a5.toString());
                }
                if(position == 6){
                    intent.putExtra("latlng", a6.toString());
                }
                if(position == 7){
                    intent.putExtra("latlng", a7.toString());
                }
                context.startActivity(intent);

            }
        });
        ((ViewPager) container).addView(itemView);
        return itemView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
