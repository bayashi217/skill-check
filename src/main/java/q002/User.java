package q002;

public class User implements Comparable {
    private Integer id;
    private String name;

    public User(String data) {
        String[] split = data.split(",", 2);
        id = Integer.parseInt(split[0]);
        name = split[1];
    }

    @Override
    public String toString() {
        return id + "," + name;
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        return id.compareTo(user.id);
    }
}
