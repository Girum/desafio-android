package com.bonin.giovanni.concretedesafioapigithub;

public class Repositorios {

    //Utilizando nomes do arquivo json para poder utilizar o GSON

    //Id

    private int Id;

    //Nome do Repositorio
    private String name;

    //Descrição do Repositorio
    private String description;

    //Nome do Autor
    private String full_name;

    //Username
    private String login;

    //Numero de Forks
    private int forks;

    //Numero de Stars
    private int stargazers_count;

    public Repositorios(String nomeRepositorio, String descricaoRepositorio, String nomeAutor, String username, int numeroStars, int numeroForks) {
        this.name = nomeRepositorio;
        this.description = descricaoRepositorio;
        this.full_name = nomeAutor;
        this.login = username;
        this.forks = numeroStars;
        this.stargazers_count = numeroForks;
    }


    public int getId() { return Id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

}
