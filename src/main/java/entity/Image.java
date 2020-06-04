package entity;

import java.util.Objects;

public class Image {
    private Integer id;
    private String name;
    private byte[] link;

    public Image(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getLink() {
        return link;
    }

    public void setLink(byte[] link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) &&
                Objects.equals(name, image.name) &&
                Objects.equals(link, image.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, link);
    }

    @Override
    public String toString() {
        return "ImageDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
