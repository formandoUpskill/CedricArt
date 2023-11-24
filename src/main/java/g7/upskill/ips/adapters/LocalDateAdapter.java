package g7.upskill.ips.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import g7.upskill.ips.model.Artwork;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LocalDateAdapter extends TypeAdapter<LocalDate> {

    @Override
    public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
//        jsonWriter.beginObject();
//        jsonWriter.name("day");
//        jsonWriter.value(localDate.getDayOfMonth());
//        jsonWriter.name("month");
//        jsonWriter.value(localDate.getMonthValue());
//        jsonWriter.name("year");
//        jsonWriter.value(localDate.getYear());
//        jsonWriter.endObject();

//        String date = String.format("%02d,%02d,%04d",localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
//        jsonWriter.value(date);
    }

    @Override
    public LocalDate read(JsonReader jsonReader) throws IOException {
//        int day = 0, month = 0, year = 0;
//
//        jsonReader.beginObject();
//
//        String fieldName = null;
//
//        while (jsonReader.hasNext()){
//            JsonToken token = jsonReader.peek();
//
//            if (token.equals(JsonToken.NAME)){
//                fieldName = jsonReader.nextName();
//            }
//
//            if ("day".equals(fieldName)){
//                token = jsonReader.peek();
//                day = jsonReader.nextInt();
//            }
//            if ("month".equals(fieldName)){
//                token = jsonReader.peek();
//                month = jsonReader.nextInt();
//            }
//            if ("year".equals(fieldName)){
//                token = jsonReader.peek();
//                year = jsonReader.nextInt();
//            }
//        }
//        jsonReader.endObject();
//
//        return LocalDate.of(year, month, day);




        JsonToken token = jsonReader.peek();

        if (token.equals(JsonToken.STRING)) {
            String dateString = jsonReader.nextString();

            // Tratar intervalos de datas
            if (dateString.contains("-")) {
                dateString = dateString.split("-")[0];
            }

            // Tratar datas aproximadas
            if (dateString.startsWith("ca.")) {
                dateString = dateString.substring(3);
            }

            // Remover espaços em branco
            dateString = dateString.trim();

            try {
                // Verificar se a data contém apenas ano (ignorar casos como "Failed to parse date:  ca. 1503")
                if (dateString.length() == 4) {
                    return LocalDate.parse(dateString + "-01-01");
                } else {
                    return LocalDate.parse(dateString);
                }
            } catch (DateTimeParseException e) {
                // Ignorar datas inválidas
                System.err.println("Failed to parse date: " + dateString);
            }
        }

        return null;

    }
}
