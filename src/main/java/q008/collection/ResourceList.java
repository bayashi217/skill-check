package q008.collection;

import q008.entity.Resource;

import java.util.List;

public class ResourceList {
    private final List<Resource> list;

    public ResourceList(List<Resource> list) {
        this.list = list;
    }

    public List<Resource> getList() {
        return list;
    }

    public void print() {
        this.list.forEach(System.out::println);
    }
}
