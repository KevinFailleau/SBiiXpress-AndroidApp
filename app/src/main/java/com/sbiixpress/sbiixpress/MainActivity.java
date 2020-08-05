package com.sbiixpress.sbiixpress;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<Object> list = new ArrayList<>();
        list.add(new String("Nos services"));
        list.add(new MenuItems("Dépannage"));
        list.add(new MenuItems("Impression"));
        list.add(new MenuItems("Vente"));
        list.add(new MenuItems("Solutions Web"));
        list.add(new MenuItems("Encre et toner"));
        list.add(new MenuItems("Développement"));
        list.add(new String("SBiiXpress"));
        list.add(new MenuItems("À propos"));
        list.add(new MenuItems("Nous contacter"));

        listView.setAdapter(new ItemAdapter(this, list));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent browserIntent;
                switch (position){
                    case 1:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sbiixpress.fr/depanxpress-maintenance-informatique-reseau/"));
                        startActivity(browserIntent);
                        break;
                    case 2:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sbiixpress.fr/imprimxpress-impression-numerique-et-3d/"));
                        startActivity(browserIntent);
                        break;
                    case 3:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sbiixpress.fr/ventexpress-vente-de-produits-informatiques-multimedias-et-high-tech/"));
                        startActivity(browserIntent);
                        break;
                    case 4:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sbiixpress.fr/webxpress-conception-de-sites-internets-e-commerce-et-communautaire/"));
                        startActivity(browserIntent);
                        break;
                    case 5:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sbiixpress.fr/inkxpress-cartouche-jet-dencre-et-toner-laser/"));
                        startActivity(browserIntent);
                        break;
                    case 6:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sbiixpress.fr/codeurxpress/"));
                        startActivity(browserIntent);
                        break;
                    case 8:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sbiixpress.fr/"));
                        startActivity(browserIntent);
                        break;
                    case 9:
                        Intent i = new Intent(getApplicationContext(), ContactActivity.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }
}
