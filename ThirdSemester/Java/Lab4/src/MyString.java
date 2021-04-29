import java.util.Objects;

public class MyString {
    private final String str;
    private final int code;

    public MyString(String str) {
        this.str = str;
        code = this.hashCode();
    }

    public int getCode() {
        return code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.str);
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == Objects.requireNonNull(obj).getClass()) {
            MyString myString = (MyString) obj;
            return  this == obj || this.code == myString.code;
        }

        return false;
    }

    @Override
    public String toString() {
        return code + " -> " + this.str;
    }
}
