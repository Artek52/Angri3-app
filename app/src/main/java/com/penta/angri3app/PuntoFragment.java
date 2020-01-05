package com.penta.angri3app;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.Objects;



public class PuntoFragment extends Fragment  {

    private Context mContext;
    private ContentValues puntoValues = new ContentValues();
    private PuntoStradaDatabase helper;

    public PuntoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_punto, container, false);
         View buttonAdd = view.findViewById(R.id.add_button);
         View buttonVis = view.findViewById(R.id.visualize_button);
         buttonVis.setOnClickListener(
                 new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Intent intent = new Intent(mContext,VisualizzaPunto.class);
                         startActivity(intent);

                     }
                 }
         );
          buttonAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                        public void onClick(View v) {

                        String myselfh,myselfp,myselff,othersS,othersP,othersF,godS,godP,godF,worldS,worldP,worldF;
                        EditText myselfStoria = Objects.requireNonNull(getView()).findViewById(R.id.myself_story);
                        myselfh=myselfStoria.getText().toString();
                        EditText myselfPresent = Objects.requireNonNull(getView()).findViewById(R.id.myself_present);
                        myselfp=myselfPresent.getText().toString();
                        EditText myselfFuture =  Objects.requireNonNull(getView()).findViewById(R.id.myself_future);
                        myselff=myselfFuture.getText().toString();
                        EditText othersPast =  Objects.requireNonNull(getView()).findViewById(R.id.others_story);
                        othersS=othersPast.getText().toString();
                        EditText othersPresent =  Objects.requireNonNull(getView()).findViewById(R.id.others_present);
                        othersP=othersPresent.getText().toString();
                        EditText othersFuture =  Objects.requireNonNull(getView()).findViewById(R.id.others_future);
                        othersF=othersFuture.getText().toString();
                        EditText godPast =  Objects.requireNonNull(getView()).findViewById(R.id.god_story);
                        godS=godPast.getText().toString();
                        EditText godPresent =  Objects.requireNonNull(getView()).findViewById(R.id.god_present);
                        godP=godPresent.getText().toString();
                        EditText godFuture =  Objects.requireNonNull(getView()).findViewById(R.id.god_future);
                        godF=godFuture.getText().toString();
                        EditText WorldPast =  Objects.requireNonNull(getView()).findViewById(R.id.world_past);
                        worldS=WorldPast.getText().toString();
                        EditText worldPresent =  Objects.requireNonNull(getView()).findViewById(R.id.world_present);
                        worldP= worldPresent.getText().toString();
                        EditText WorldFuture =  Objects.requireNonNull(getView()).findViewById(R.id.world_future);
                        worldF=WorldFuture.getText().toString();
                        puntoValues.put("MYSELF_PAST",myselfh);
                        puntoValues.put("MYSELF_PRESENT",myselfp);
                        puntoValues.put("MYSELF_FUTURE",myselff);
                        puntoValues.put("OTHERS_PAST",othersS);
                        puntoValues.put("OTHERS_PRESENT",othersP);
                        puntoValues.put("OTHERS_FUTURE",othersF);
                        puntoValues.put("GOD_PAST",godS);
                        puntoValues.put("GOD_PRESENT",godP);
                        puntoValues.put("GOD_FUTURE",godF);
                        puntoValues.put("WORLD_PAST",worldS);
                        puntoValues.put("WORLD_PRESENT",worldP);
                        puntoValues.put("WORLD_FUTURE",worldF);
                        SQLiteDatabase db = helper.getWritableDatabase();
                        db.insert("PUNTOSTRADA", null, puntoValues);
                        db.close();
                      Toast.makeText(getActivity(),"RECORD AGGIUNTO",Toast.LENGTH_SHORT).show();
                    }

                }

        );

        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mContext = context ;
        helper = new PuntoStradaDatabase(mContext);
    }


}
