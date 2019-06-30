package com.bonin.giovanni.concretedesafioapigithub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RepositoriosAdapter extends ListAdapter<Repositorios, RepositoriosAdapter.ViewHolder> {
//public class RepositoriosAdapter extends RecyclerView.Adapter<RepositoriosAdapter.ViewHolder> {


    public static final DiffUtil.ItemCallback<Repositorios> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Repositorios>() {
                @Override
                public boolean areItemsTheSame(Repositorios oldItem, Repositorios newItem) {
                    return oldItem.getId() == newItem.getId();
                }
                @Override
                public boolean areContentsTheSame(Repositorios oldItem, Repositorios newItem) {
                    return (oldItem.getName().equals(newItem.getName()) && oldItem.getDescription().equals(newItem.getDescription())
                            && oldItem.getFull_name().equals(newItem.getFull_name())  && oldItem.getLogin().equals(newItem.getLogin())
                            && oldItem.getForks() == newItem.getForks()  && oldItem.getStargazers_count() == newItem.getStargazers_count()
                    );
                }
            };

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView NomeRepositorio;
        public TextView DescricaoRepositorio;
        public TextView Username;
        public TextView NomeAutor;
        public TextView NumeroForks;
        public TextView NumeroStars;


        public ViewHolder(View itemView){
            super(itemView);

            NomeRepositorio = (TextView) itemView.findViewById(R.id.textViewNomeRepositorio);
            DescricaoRepositorio = (TextView) itemView.findViewById(R.id.textViewDescricaoRepositorio);
            Username = (TextView) itemView.findViewById(R.id.textViewUsername);
            NomeAutor = (TextView) itemView.findViewById(R.id.textViewNomeAutor);
            NumeroForks = (TextView) itemView.findViewById(R.id.textViewNumeroForks);
            NumeroStars = (TextView) itemView.findViewById(R.id.textViewNumeroStars);

        }
    }

    private List<Repositorios> mRepositorios;

    /*public RepositoriosAdapter(List<Repositorios> repositorios){
        this.mRepositorios = repositorios;
    }*/

    public RepositoriosAdapter(List<Repositorios> repositorios) {
        super(DIFF_CALLBACK);
        this.mRepositorios = repositorios;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View repositoriosView = inflater.inflate(R.layout.repositorio_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(repositoriosView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RepositoriosAdapter.ViewHolder viewHolder, int position) {
        Repositorios repositorios =  mRepositorios.get(position);

        //Repositorios repositorios = getItem(position);

        TextView NomeRepositorio = viewHolder.NomeRepositorio;
        TextView DescricaoRepositorio = viewHolder.DescricaoRepositorio;
        TextView Username = viewHolder.Username;
        TextView NomeAutor = viewHolder.NomeAutor;
        TextView NumeroForks = viewHolder.NumeroForks;
        TextView NumeroStars = viewHolder.NumeroStars;

        NomeRepositorio.setText(repositorios.getName());
        DescricaoRepositorio.setText(repositorios.getDescription());
        Username.setText(repositorios.getLogin());
        NomeAutor.setText(repositorios.getFull_name());
        NumeroForks.setText(String.valueOf(repositorios.getForks()));
        NumeroStars.setText(String.valueOf(repositorios.getStargazers_count()));
    }

    @Override
    public int getItemCount() {
        return mRepositorios.size();
    }

    public void addMaisRepositorios(List<Repositorios> novosRepositorios) {
        mRepositorios.addAll(novosRepositorios);
        submitList(mRepositorios);
    }

    public void addRepositorios(Repositorios novosRepositorios) {
        mRepositorios.add(novosRepositorios);
        submitList(mRepositorios);
    }

}
