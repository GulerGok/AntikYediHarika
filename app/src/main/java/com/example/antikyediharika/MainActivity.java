package com.example.antikyediharika;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.antikyediharika.MainActivity.selectedImage;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Bitmap selectedImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     ListView listView = findViewById(R.id.listView);

       final ArrayList<String> wonders = new ArrayList<>();
        wonders.add("Babil'in Asma Bahçeleri");
        wonders.add("Keops Piramidi");
        wonders.add("Zeus Heykeli");
        wonders.add("Rodos Heykeli");
        wonders.add("İskenderiye Feneri");
        wonders.add("Halikarnas Mozolesi");
        wonders.add("Artemis Tapınağı");

        final ArrayList<String> countryNames = new ArrayList<>();
        countryNames.add("Nerede olduğu hala bilinmemektedir.");
        countryNames.add("Mısır - Kahire");
        countryNames.add("Yunanistan - Olimpos");
        countryNames.add("Türkiye Ege Denizi - Rodos Adası");
        countryNames.add("Mısır - İskenderiye");
        countryNames.add("Türkiye - Bodrum");
        countryNames.add("Türkiye - İzmir Selçuk / Efes Antik Kenti");

        Bitmap babil = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.babil);
        Bitmap keops = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.keops);
        Bitmap zeus = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.zeus);
        Bitmap rodos = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.rodos);
        Bitmap iskenderiye = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.iskenderiye);
        Bitmap halikarnas = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.halikarnas);
        Bitmap artemis = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.artemis);

        final ArrayList <Bitmap> wonderImages = new ArrayList<>();
        wonderImages.add(babil);
        wonderImages.add(keops);
        wonderImages.add(zeus);
        wonderImages.add(rodos);
        wonderImages.add(iskenderiye);
        wonderImages.add(halikarnas);
        wonderImages.add(artemis);


         ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,wonders);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent =  new Intent(getApplicationContext(),DetailActivity.class);
            intent.putExtra("name",wonders.get(position));
            intent.putExtra("countryname",countryNames.get(position));
   //         selectedImage = wonderImages.get(position);
            Singleton singleton = Singleton.getInstance();
            singleton.setChosenImage(wonderImages.get(position));
            startActivity(intent);
         }
        });

    }
}
