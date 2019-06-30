package com.bonin.giovanni.concretedesafioapigithub;

import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

//public class ProcuraRepositorios extends AsyncTask<Void, Void, Repositorios> {
    public class ProcuraRepositorios extends AsyncTask<Void, Void, String> {


    private final String url_repositorio;

    public ProcuraRepositorios(String url_repositorio) {
        this.url_repositorio = url_repositorio;
    }

    @Override
    //protected Repositorios doInBackground(Void... voids) {
        protected String doInBackground(Void... voids) {

        StringBuilder resposta = new StringBuilder();
        try{
            URL url = new URL(this.url_repositorio);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                resposta.append(scanner.next());
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        //return new Gson().fromJson(String.valueOf(resposta), Repositorios.class);
        return String.valueOf(resposta);
    }
}
