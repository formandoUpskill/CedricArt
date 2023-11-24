package g7.upskill.ips.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import g7.upskill.ips.model.Artwork;

import java.io.IOException;
import java.time.LocalDate;

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


        jsonReader.beginObject();

        JsonToken token = jsonReader.peek();


        String fieldname = null;

        LocalDate date = null;
        String dateString = null;

        while (jsonReader.hasNext()) {

            if (token.equals(JsonToken.NAME)) {
                //get the current token
                fieldname = jsonReader.nextName();
            }

            if (("created_at".equals(fieldname)) || ("updated_at".equals(fieldname))) {
                // Mova para o próximo token
                token = jsonReader.peek();

                if (token.equals(JsonToken.STRING)) {
                    // Se o próximo token for uma String, leia a data
                    dateString = jsonReader.nextString();
                    dateString = dateString.substring(0, 10);

                    // Converta a String em um objeto LocalDate
                    date = LocalDate.parse(dateString);
                }
            } else {
                // Se não for um campo de data, avance para o próximo token
                jsonReader.skipValue();
                token = jsonReader.peek();
            }
        }

        jsonReader.endObject();

// Certifique-se de que a data não seja nula antes de retornar
        return date;

    }
}
