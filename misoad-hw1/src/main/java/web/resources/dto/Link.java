package web.resources.dto;

import common.Relation;

public class Link {

    Relation rel;
    String href;

    public Link() {
    }

    public Link(Relation rel, String href) {
        this.rel = rel;
        this.href = href;
    }

    public Relation getRel() {
        return rel;
    }

    public void setRel(Relation rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
