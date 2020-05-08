package q008.collection;

import q008.entity.JavaFile;

import java.util.List;
import java.util.stream.Collectors;

public class JavaFileList {
    private final List<JavaFile> list;

    public JavaFileList(List<JavaFile> list) {
        this.list = list;
    }

    public ResourceList getHasEmbeddedStringResourceList() {
        return new ResourceList(this.list.stream().flatMap(javaFile ->
                javaFile.getHasEmbeddedStringResourceList().getList().stream()
        ).collect(Collectors.toList()));
    }
}
