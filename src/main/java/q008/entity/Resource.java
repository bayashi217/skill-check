package q008.entity;

public class Resource {
    private final String filename;
    private final int line;
    private final String resource;

    public Resource(String filename, int line, String resource) {
        this.filename = filename;
        this.line = line;
        this.resource = resource;
    }

    @Override
    public String toString() {
        return filename + "(" + line + "):" + resource;
    }
}
