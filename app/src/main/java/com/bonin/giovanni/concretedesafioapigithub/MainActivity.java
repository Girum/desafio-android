package com.bonin.giovanni.concretedesafioapigithub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    //public TextView txtMain;
    private JSONObject read;
    private JSONArray read_items;
    private List<Repositorios> repos = new ArrayList<Repositorios>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_layout);

        RecyclerView rvRepositorios = (RecyclerView) findViewById(R.id.rvRepositorios);



        try {
            //Repositorios retorno = new ProcuraRepositorios("https://api.github.com/search/repositories?q=language:Java&sort=stars&page=1").execute().get();
            String retorno = new ProcuraRepositorios("https://api.github.com/search/repositories?q=language:Java&sort=stars&page=1").execute().get();

            try {
                read = new JSONObject(retorno);
                read_items = new JSONArray(read.getString("items"));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        for (int i = 0; i <= read_items.length(); i++) {
            String name;
            String full_name;
            String login;
            String description;
            String forks;
            String stargazers_count;

            try {
                name = read_items.getJSONObject(i).getString("name");

                full_name = read_items.getJSONObject(i).getString("full_name");

                String owner = read_items.getJSONObject(i).getString("owner");
                JSONObject read_Owner = new JSONObject(owner);
                login = read_Owner.getString("login");

                description = read_items.getJSONObject(i).getString("description");
                if(description.length() > 80){
                    description = description.substring(0,80) + "...";
                }

                forks = read_items.getJSONObject(i).getString("forks");

                stargazers_count = read_items.getJSONObject(i).getString("stargazers_count");

                repos.add(new Repositorios(name, description, full_name, login, Integer.valueOf(forks), Integer.valueOf(stargazers_count)));
                //adapter.addRepositorios(new Repositorios(name, description, full_name, login, Integer.valueOf(forks), Integer.valueOf(stargazers_count)));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //adapter.addMaisRepositorios(repos);

        }

        //adapter.addMaisRepositorios(repos);
        RepositoriosAdapter adapter = new RepositoriosAdapter(repos);
        adapter.notifyItemInserted(repos.size() -1);

        rvRepositorios.setAdapter(adapter);
        rvRepositorios.setLayoutManager(new LinearLayoutManager(this));
        //rvRepositorios.scrollToPosition(adapter.getItemCount() - 1);


    }
}
