package br.com.infnet.assessment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.ImportResource;

import java.time.LocalDateTime;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Pintura {

    private int id;

    private String title;

    private int date_end;

    @JsonProperty("data")
    private String data;


    public Pintura() {
    }


    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getDate_end() {
        return this.date_end;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate_end(int date_end) {
        this.date_end = date_end;
    }


   /* public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Pintura)) return false;
        final Pintura other = (Pintura) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        if (this.getDate_end() != other.getDate_end()) return false;


    }
    protected boolean canEqual(final Object other) {
        return other instanceof Pintura;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        result = result * PRIME + this.getDate_end();
        return result;
    }
    */

    public String toString() {
        return "Pintura(id=" + this.getId() + ", title=" + this.getTitle() + ", date_end=" + this.getDate_end() +")";
    }


}

