package com.example.myapplication_mapnavigationdrawer.ui.home;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication_mapnavigationdrawer.MainActivity;
import com.example.myapplication_mapnavigationdrawer.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomeFragment extends Fragment implements
        OnMapReadyCallback
{

    private HomeViewModel homeViewModel;
   // private AppCompatActivity;
    private final static int REQUEST_PERMISSIONS = 1;

    @Override
    public void onRequestPermissionsResult ( int requsetCode, String
            permissions[],int[] grantResults){
        switch (requsetCode) {
            case REQUEST_PERMISSIONS:
                for (int result : grantResults) {
                    if (result != PackageManager.PERMISSION_GRANTED) {
                        getActivity().finish();
                    } else {
                        SupportMapFragment map =
                                (SupportMapFragment) getChildFragmentManager().findFragmentById ( R.id.map );
                        map.getMapAsync ( this );
                    }
                }
                break;
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.activity_main2, container, false);

        if (ActivityCompat.checkSelfPermission ( getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION)!=
                PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions ( getActivity(),new
                            String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_PERMISSIONS);
        else{
            SupportMapFragment map =
                    (SupportMapFragment) getChildFragmentManager().findFragmentById ( R.id.map );
            map.getMapAsync ( this );
        }

/*        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getActivity(, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
 */
        return root;
    }

    @Override
    public void onMapReady(GoogleMap map){
        if (ActivityCompat.checkSelfPermission ( getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)!=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission ( getActivity(),
                        Manifest.permission.ACCESS_COARSE_LOCATION)!=
                        PackageManager.PERMISSION_GRANTED)
            return;
        map.setMyLocationEnabled ( true );
        MarkerOptions m1 = new MarkerOptions ();

        int height = 100;
        int width = 100;
        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.mipmap.loticon);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);

        m1.position ( new LatLng( 25.033611, 121.565000 ) );
        m1.title("台北101");
        m1.draggable ( true );
        //m1.icon(BitmapDescriptorFactory.fromResource(smallMarker));
        m1.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        map.addMarker ( m1 );

        MarkerOptions m2 = new MarkerOptions ();
        m2.position ( new LatLng ( 25.047924, 121.517081 ) );
        m2.title ( "台北車站" );
        m2.draggable ( true );
        m2.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        map.addMarker ( m2 );

        map.moveCamera ( CameraUpdateFactory.newLatLngZoom (
                new LatLng ( 25.034,121.545 ), 13 ) );

        //Toast
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(final Marker marker) {
                Toast.makeText(getActivity(),"标记被点击了，这里的纬度是:"+marker.getPosition().latitude+"",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //點marker跳infowindo
        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(),
                        infowindow.class);
                startActivity(intent);
            }
        });
    }
}