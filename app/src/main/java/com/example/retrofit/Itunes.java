package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Itunes {
    class Respuesta {
        List<Avion> documents;
    }

    class Avion {
        String name;
        Fields fields;
    }

    class Fields {
        Value Nombre;
        Value Construidos;
        Value PrimerVuelo;
        Value Imagen;
        Value Estado;
    }

    class Value {
        String stringValue;
        Integer integerValue;
    }


    public static Api api = new Retrofit.Builder()
            .baseUrl("https://firestore.googleapis.com/v1/projects/avionesinfo-1c7b0/databases/(default)/documents/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api.class);

    public interface Api {
        @GET("Aviones/")
        Call<Respuesta> obtener();
    }


}
