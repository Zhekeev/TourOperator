package service;

import java.util.Base64;

public class ImageEncoder {
    public String encode(byte[] bytes) {

        Base64.Encoder encoder = Base64.getEncoder();

        String imageUrl = "data:image/png;base64," + encoder.encodeToString(bytes);

        return imageUrl;
    }
}
