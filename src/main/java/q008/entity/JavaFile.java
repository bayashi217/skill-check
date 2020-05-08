package q008.entity;

import q008.collection.ResourceList;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class JavaFile {
    private final String filename;
    private final List<String> resources;

    public JavaFile(String filename, List<String> resources) {
        this.filename = filename;
        this.resources = resources;
    }

    public ResourceList getHasEmbeddedStringResourceList() {
        AtomicInteger line = new AtomicInteger();
        return new ResourceList(this.resources.stream().filter(this::hasEmbeddedString).map(resource -> {
            line.getAndIncrement();
            return new Resource(
                    this.filename,
                    line.get(),
                    resource
            );
        }).collect(Collectors.toList()));
    }

    private Boolean hasEmbeddedString(String resource) {
        if (resource.matches(" */?\\*.*")) {
            return false;
        }
        return 0 < resource.indexOf("\"") || 0 < resource.indexOf("'");
    }

}
