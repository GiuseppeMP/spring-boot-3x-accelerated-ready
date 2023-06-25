package twlabsbrazil.handson.genai.shared;

/**
 * Pessoa
 */
public class Pessoa {

    private int age;
    private String name;

    public static Pessoa create(String string, int i) {

        Pessoa pessoa = new Pessoa();
        pessoa.setName(string);
        pessoa.setAge(i);
        return pessoa;
    }

    private Pessoa() {

    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
