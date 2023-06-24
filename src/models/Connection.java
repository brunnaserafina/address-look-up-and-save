package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Connection {
    public Address searchCep(String cep) throws IOException {
        URI website = URI.create("https://viacep.com.br/ws/" + cep + "/json");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(website)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return new Gson().fromJson(json, Address.class);
        } catch (NumberFormatException | IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
