package twlabsbrazil.handson.genai.model;

/**
 * Pessoa
 */
public class Pessoa {

    private int age;
    private String name;

    public static Pessoa create(String name, int age) throws IllegalArgumentException {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "The string param must be not null, not empty and not blank");
        }

        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("The age param must be between 0 and 120");
        }

        Pessoa pessoa = new Pessoa();
        pessoa.setName(name);
        pessoa.setAge(age);
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
