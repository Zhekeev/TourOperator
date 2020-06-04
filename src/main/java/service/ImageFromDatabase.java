package service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

public class ImageFromDatabase {
    public String getImageFromDataBase(Blob blob) throws SQLException, IOException {

        String base64Image;
        byte[] buffer;

        int bytesRead;
        int maxSize = 4096;
        int minusOne = -1;

        if (blob == null) {
            return "error";
        } else {
            buffer = new byte[maxSize];

            InputStream inputStream = blob.getBinaryStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            while ((bytesRead = inputStream.read(buffer)) != minusOne) {
                outputStream.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = outputStream.toByteArray();
            base64Image = Base64.getEncoder().encodeToString(imageBytes);
            inputStream.close();
            outputStream.close();
            return base64Image;
        }
    }
}
