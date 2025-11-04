import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public void guardarJson(Film film) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(film); // convierte el objeto en JSON

        try {
            FileWriter escritor = new FileWriter("pelicula_" + film.getEpisode_id() + ".json");
            escritor.write(json);
            escritor.close();
            System.out.println("✅ Archivo creado correctamente: pelicula_" + film.getEpisode_id() + ".json");
        } catch (IOException e) {
            System.out.println("❌ Error al guardar el archivo: " + e.getMessage());
        }
    }
}

